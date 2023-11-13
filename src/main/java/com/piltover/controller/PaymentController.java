package com.piltover.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.piltover.config.PaypalPaymentIntent;
import com.piltover.config.PaypalPaymentMethod;
import com.piltover.service.PaypalService;
import com.piltover.service.VNPayService;
import com.piltover.util.PaypalUtils;

@RestController
public class PaymentController {

    @Autowired
    private PaypalService paypalService;

    @Autowired
    private VNPayService vnPayService;

    private Logger log = LoggerFactory.getLogger(getClass());

    /* Paypal */

    public static final String URL_PAYPAL_SUCCESS = "pay/success";
    public static final String URL_PAYPAL_CANCEL = "pay/cancel";

    @GetMapping("/pay")
    public String pay(HttpServletRequest request) {
        Double price = 100.0;
        String cancelUrl = PaypalUtils.getBaseURL(request) + "/" + URL_PAYPAL_CANCEL;
        String successUrl = PaypalUtils.getBaseURL(request) + "/" + URL_PAYPAL_SUCCESS;
        try {
            Payment payment = paypalService.createPayment(price, "USD", PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale, "payment description", cancelUrl, successUrl);
            for (Links links : payment.getLinks())
                if (links.getRel().equals("approval_url"))
                    return links.getHref();
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return "redirect:/";
    }

    @GetMapping(URL_PAYPAL_CANCEL)
    public String cancelPay() {
        return "redirect:/";
    }

    @GetMapping(URL_PAYPAL_SUCCESS)
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved"))
                return "redirect:/purchase/" + 3;
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return "redirect:/";
    }

    /* Paypal */

    /* VNPay */

    @GetMapping("/submitOrder")
    public String submidOrder(HttpServletRequest request) {
        int orderTotal = (int) Math.round(100);
        String orderInfo = "Giao dịch Fstore";
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        String vnpayUrl = vnPayService.createOrder(orderTotal, orderInfo, baseUrl);
        return vnpayUrl;
    }

    @GetMapping("/vnpay-payment")
    public String GetMapping(HttpServletRequest request, Model model) {
        int paymentStatus = vnPayService.orderReturn(request);

        String orderInfo = request.getParameter("vnp_OrderInfo");
        String paymentTime = request.getParameter("vnp_PayDate");
        String transactionId = request.getParameter("vnp_TransactionNo");
        String totalPrice = request.getParameter("vnp_Amount");

        model.addAttribute("orderId", orderInfo);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("paymentTime", paymentTime);
        model.addAttribute("transactionId", transactionId);

        return paymentStatus == 1 ? "ordersuccess" : "orderfail";
    }

    /* VNPay */

}
