package com.piltover.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.dto.request.DiscountReq;
import com.piltover.entity.Account;
import com.piltover.entity.Discount;
import com.piltover.service.AccountService;
import com.piltover.service.DiscountService;
import com.piltover.util.ResponeUtil;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/discount")
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

	@PostMapping("/insert")
	public ResponseEntity<?> insertDiscount(@RequestBody DiscountReq dto) {
//		Account acc=as.findUserByID(Long.valueOf(2345673452l));
		
		dto.setCreate_User((long)1234567890);
		 
		discountService.insertDiscount(dto);
		respUtill.putRespone("message", "Create discount susscess");
		return ResponseEntity.ok(respUtill.getRespone());
	}
	
//	@PostMapping("/create")
//	public ResponseEntity<?> createDiscount(@RequestBody Discount disc) {
//		
//		Account acc=as.findUserByID(Long.valueOf(2345673452l));
//		
//		disc.setCreateUser(acc);
//		disc.setUpdateUser(acc);
//		discountService.createDiscount(disc);
//		
//	
//		return ResponseEntity.ok(respUtill.getRespone());
//		
//	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> Delete(@PathVariable("id") Long id){
//		Account acc=as.findUserByID(Long.valueOf(2345673452l));
		System.out.println("Id of discountDelete: "+id);
			discountService.deleteDiscount(id);
			
			respUtill.putRespone("message", "Delete discount susscess");
			return ResponseEntity.ok(respUtill.getRespone());
			
	}
}
