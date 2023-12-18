package com.piltover.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piltover.entity.Account;
import com.piltover.service.AccountService;
import com.piltover.service.LogService;
import com.piltover.util.IDGenerator;
import com.piltover.util.ResponeUtil;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin/account")
public class AccountController {
	@Autowired
	AccountService accountService;
	
	@Autowired
	LogService logService;

	@Autowired
	ResponeUtil responeUtil;

	@Autowired
	IDGenerator idGenerator;

	@GetMapping("/getAllAccount")
	public ResponseEntity<?> getAllAccount() {
		return ResponseEntity.ok(accountService.getAllAccount());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Account> getAccountByUsername(@PathVariable Long id) {
		return ResponseEntity.ok(accountService.findUserByID(id));
	}

	@PostMapping("/createAccount")
	public ResponseEntity<?> createAccount(@RequestBody Account account) {

		if (accountService.isEmailExists(account.getEmail())) {
			// Trả về lỗi 400 - BadRequest
			responeUtil.putRespone("message", "Địa chỉ email đã tồn tại trong hệ thống");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(responeUtil.getRespone());
		}

		if (accountService.isPhoneExists(account.getPhone())) {
			// Trả về lỗi 400 - BadRequest
			responeUtil.putRespone("message", "Số điện thoại đã tồn tại trong hệ thống");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(responeUtil.getRespone());
		}

		account.setId(idGenerator.generateRandomNumbers());
		Account newAccount = accountService.createAccount(account);

		responeUtil.putRespone("message", "Tạo tài khoản thành công");
		responeUtil.putRespone("newAccount", newAccount);

		System.out.println(responeUtil.getRespone());
		return ResponseEntity.ok(responeUtil.getRespone());
	}

	@PostMapping("/test")
	public ResponseEntity<?> testRespone() {
		return ResponseEntity.ok(responeUtil.getRespone());
	}

	@GetMapping("/currentAccount")
	public ResponseEntity<Account> getCurrentAccount() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Long upUser = accountService.getId(username);
		return ResponseEntity.ok(accountService.findUserByID(upUser));
	}
	
	@GetMapping("/findAllLog")
	public ResponseEntity<?> findAllLog() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Long upUser = accountService.getId(username);
		return ResponseEntity.ok(logService.getAllLogByID(upUser));
	}
	
	@DeleteMapping("/block/{id}")
	public ResponseEntity<?> block(@PathVariable("id") Long id) {
		ResponeUtil respu = new ResponeUtil();
		
		if(id == null) {
			respu.putRespone("message", "Không tìm thấy user hợp lệ");
			return ResponseEntity.badRequest().body(respu.getRespone());
		}
		if (!accountService.isIDExists(Long.valueOf(id))){
			respu.putRespone("message", "ID user không hợp lệ");
			return ResponseEntity.badRequest().body(respu.getRespone());
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Long currentUser = accountService.getId(username);
		
		if (currentUser.equals(id)){
			respu.putRespone("message", "Bạn không thể xóa chính mình");
			return ResponseEntity.badRequest().body(respu.getRespone());
		}
		
		accountService.deleteAccount(id);
		respu.putRespone("message", "Xóa thành công");
		
		return ResponseEntity.ok().body(respu.getRespone());
	}

}
