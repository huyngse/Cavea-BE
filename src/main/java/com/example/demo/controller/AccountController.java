package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.TokenDTO;
import com.example.demo.DTO.UserNameDTO;
import com.example.demo.DTO.registerDTO;
import com.example.demo.Entities.Account;
import com.example.demo.Service.AccountService;

@RestController
@RequestMapping("/login")
@CrossOrigin("http://localhost:3000")
public class AccountController {

	@Autowired
	private AccountService accservice;

	int count = 52;

	@GetMapping("/account")
	public Account getUserOrEmail(String username) {
		Account getUserorEmail = accservice.getUSernameorEmail(username);
		if (getUserorEmail != null) {
			return getUserorEmail;
		}
		return null;
	}
	@PostMapping("/getAccount")
	public Account getAccountByUsername(@RequestBody UserNameDTO DTO) {
		String username = DTO.getUsername();
		Account getAccount = accservice.getAccountByUserName(username);
		if(getAccount == null){
			throw new RuntimeException("Không tìm thấy TK!!!");
		}
		return getAccount;
		
	}
	@PostMapping("/checklogin")
	public Account checkLogin(@RequestBody LoginDTO loginDTO) {
		String username = loginDTO.getUsername();
		String password = loginDTO.getPassword();
		Account checklogin = accservice.checkLogin(username, password);
		if (checklogin == null) {
			throw new RuntimeException("Không có tài khoản");
		}
		return checklogin;
	}

	@PostMapping("/register")
	public Account register(@RequestBody registerDTO registerDTO) {
		Account account = accservice.register(registerDTO);
		if (account == null) {
			throw new RuntimeException("Lỗi trong Account Controller");
		}
		return account;
	}
	
	@PostMapping("/registerVerify")
	public void registerVerify(@RequestBody TokenDTO DTO) {
		accservice.setEnable(DTO.getToken());
	}
	
	@GetMapping("/forgotpassword")
	public void restPassword(String newPassword, String token) {
		accservice.setNewPassWord(token, newPassword);
	}
}
