package com.piltover.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.piltover.config.PaypalPaymentIntent;
import com.piltover.config.PaypalPaymentMethod;
import com.piltover.entity.BookingDetail;
import com.piltover.entity.Discount;
import com.piltover.repository.BookingDetailRepository;
import com.piltover.repository.BookingRepository;
import com.piltover.repository.DiscountRepository;
import com.piltover.service.PaypalService;
import com.piltover.service.VNPayService;
import com.piltover.util.PaypalUtils;

@CrossOrigin("*")
@RestController
public class PaymentController {

    @Autowired
    private PaypalService paypalService;

    @Autowired
    private VNPayService vnPayService;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private DiscountRepository discountRepository;

    @Autowired
    private BookingDetailRepository bookingDetailRepository;

    private Logger log = LoggerFactory.getLogger(getClass());

    private BookingDetail bookingDetail;

    @PostMapping("/nopay")
    public String nopay(HttpServletRequest request, HttpServletResponse response, @RequestBody BookingDetail data)
            throws IOException {
        bookingDetail = data;
        bookingDetail.getBooking().setCreateTime(new Date());
        bookingDetail.getBooking().setUpdateTime(new Date());
        try {
            successPurchase(0, response);
            return "http://localhost:4200/history";
        } catch (Exception e) {
            return "http://localhost:4200/";
        }
    }

    /* Paypal */

    public static final String URL_PAYPAL_SUCCESS = "pay/success";
    public static final String URL_PAYPAL_CANCEL = "pay/cancel";

    @PostMapping("/paypal")
    public String pay(HttpServletRequest request, @RequestBody BookingDetail data) {
        bookingDetail = data;
        bookingDetail.getBooking().setCreateTime(new Date());
        bookingDetail.getBooking().setUpdateTime(new Date());
        String cancelUrl = PaypalUtils.getBaseURL(request) + "/" + URL_PAYPAL_CANCEL;
        String successUrl = PaypalUtils.getBaseURL(request) + "/" + URL_PAYPAL_SUCCESS;
        try {
            Payment payment = paypalService.createPayment(bookingDetail.getBooking().getTotalPrice(), "USD",
                    PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale, "payment description", cancelUrl, successUrl);
            for (Links links : payment.getLinks())
                if (links.getRel().equals("approval_url")) {
                    return links.getHref();
                }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return "http://localhost:4200/";
    }

    @GetMapping(URL_PAYPAL_SUCCESS)
    public void successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId,
            HttpServletResponse response) throws IOException {
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                successPurchase(1, response);
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
    }

    @GetMapping(URL_PAYPAL_CANCEL)
    public void cancelPay(HttpServletResponse response) throws IOException {
        response.sendRedirect("http://localhost:4200/");
    }

    /* Paypal */

    /* VNPay */

    @PostMapping("/vnpay")
    public String submidOrder(HttpServletRequest request, @RequestBody BookingDetail data) {
        bookingDetail = data;
        bookingDetail.getBooking().setCreateTime(new Date());
        bookingDetail.getBooking().setUpdateTime(new Date());
        String orderInfo = "Giao dịch Piltover";
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        String vnpayUrl = vnPayService.createOrder(data.getBooking().getTotalPrice().intValue(), orderInfo,
                baseUrl);
        return vnpayUrl;
    }

    @GetMapping("/vnpay-payment")
    public void GetMapping(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        int paymentStatus = vnPayService.orderReturn(request);

        String orderInfo = request.getParameter("vnp_OrderInfo");
        String paymentTime = request.getParameter("vnp_PayDate");
        String transactionId = request.getParameter("vnp_TransactionNo");
        String totalPrice = request.getParameter("vnp_Amount");

        model.addAttribute("orderId", orderInfo);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("paymentTime", paymentTime);
        model.addAttribute("transactionId", transactionId);
        if (paymentStatus == 1) {
            successPurchase(2, response);
        } else {
            response.sendRedirect("http://localhost:4200/");
        }
    }

    /* VNPay */

    public void successPurchase(Integer num, HttpServletResponse response) throws IOException {
        if (num == 0) {
            bookingDetail.getBooking().setStatus(0);
        } else {
            bookingDetail.getBooking().setStatus(1);
        }
        if (num == 1) {
            bookingDetail.getBooking().setTotalPrice(
                    bookingDetail.getAdult()
                            * bookingDetail.getBooking().getTourDate().getTour().getPrice().getAdultPrice()
                            + bookingDetail.getChildren() * bookingDetail.getBooking().getTourDate().getTour()
                                    .getPrice().getChildrenPrice()
                            + bookingDetail.getSurcharge());
            if (bookingDetail.getBooking().getDiscount() != null) {
                if (((bookingDetail.getBooking().getTotalPrice() - bookingDetail.getSurcharge())
                        * (bookingDetail.getBooking().getDiscount().getPercentage() / 100)) <= bookingDetail
                                .getBooking()
                                .getDiscount().getMax()) {
                    bookingDetail.getBooking().setTotalPrice(
                            bookingDetail.getBooking().getTotalPrice()
                                    - ((bookingDetail.getBooking().getTotalPrice() - bookingDetail.getSurcharge())
                                            * bookingDetail.getBooking().getDiscount().getPercentage() / 100));
                } else {
                    bookingDetail.getBooking().setTotalPrice(
                            bookingDetail.getBooking().getTotalPrice()
                                    - bookingDetail.getBooking().getDiscount().getMax());
                }
            }
        }
        if (bookingDetail.getBooking().getDiscount() != null && num != 0) {
            Discount discount = discountRepository.findById(bookingDetail.getBooking().getDiscount().getId()).get();
            discount.setAmount(discount.getAmount() - 1);
            if (discount.getAmount() == 0) {
                discount.setIsDelete(true);
            }
            discountRepository.save(discount);
        }
        bookingRepository.save(bookingDetail.getBooking());
        bookingDetailRepository.save(bookingDetail);
        if (num != 0) {
            response.sendRedirect("http://localhost:4200/history");
        }
    }
}
