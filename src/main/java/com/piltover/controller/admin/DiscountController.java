package com.piltover.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.dto.request.DiscountReq;
import com.piltover.dto.request.Discount_UpdateReq;
import com.piltover.entity.Discount;
import com.piltover.service.AccountService;
import com.piltover.service.DiscountService;
import com.piltover.util.ResponeUtil;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin/discount")
public class DiscountController {
	

	@Autowired
	AccountService as;
	
	@Autowired
	DiscountService discountService;

	@Autowired
	ResponeUtil respUtill;

	@GetMapping("/getAll")
	public List<Discount> ReadAllDiscount() {
		return discountService.ReadAllDiscounts();
	}

	@GetMapping("/{id}")
	public Discount readOneByDiscountID(@PathVariable Long id) {
		return discountService.ReadOneByDiscountID(id);
	}

	@PutMapping("/update/{did}")
	public ResponseEntity<?> Update(@PathVariable("did") Long id, @RequestBody Discount_UpdateReq request) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();

		Long upUser = as.getId(username);
		
		request.setUpdate_User(upUser);
		
		discountService.updateDiscount2(id, request);
		
		respUtill.putRespone("message", "Update discount susscess");
		return ResponseEntity.ok(respUtill.getRespone());
	}
	
	@PostMapping("/insert")
	public ResponseEntity<?> insertDiscount(@RequestBody DiscountReq dto) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();

		Long upUser = as.getId(username);
		
		dto.setCreate_User(upUser);
		discountService.insertDiscount(dto);
		respUtill.putRespone("message", "Create discount susscess");
		return ResponseEntity.ok(respUtill.getRespone());
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> Delete(@PathVariable("id") Long id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();

		Long upUser = as.getId(username);

		discountService.deleteDiscount(id,upUser);

		respUtill.putRespone("message", "Delete discount susscess");
		return ResponseEntity.ok(respUtill.getRespone());
	}
	
	@GetMapping("/check/{id}")
	public ResponseEntity<?> check(@PathVariable("id") Long id) {
//		respUtill.putRespone("message", "Delete discount susscess");
		return ResponseEntity.ok(discountService.checkAmountById(id));
	}
	
	@DeleteMapping("/active/{id}")
	public ResponseEntity<?> Active(@PathVariable("id") Long id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();

		Long upUser = as.getId(username);
		
		discountService.deleteDiscount(id,upUser);		

		respUtill.putRespone("message", "Active discount susscess");
		return ResponseEntity.ok(respUtill.getRespone());
	}
	
	@PutMapping("/addAmount/{did}")
	public ResponseEntity<?> Active(@PathVariable("did") Long id,@RequestBody int Amount) {
		
		discountService.addAmount(id, Amount);
		
		respUtill.putRespone("message", "Add amount susscess");
		return ResponseEntity.ok(respUtill.getRespone());
	}
	
	@GetMapping("/checkd/{id}")
	public ResponseEntity<?> check_Delete(@PathVariable("id")Long id) {
		return ResponseEntity.ok(discountService.checkDelete(id));
				
	}
		
}
