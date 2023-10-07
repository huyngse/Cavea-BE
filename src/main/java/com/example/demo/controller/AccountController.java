package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Account;
import com.example.demo.Service.AccountService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/login")
public class AccountController {
	
	@Autowired
	private AccountService accservice;

	@GetMapping("/account")
	public Account getUserOrEmail(String username) {
		Account getUserorEmail = accservice.getUSernameorEmail(username);
		if (getUserorEmail != null) {
			return getUserorEmail; 
	}
		return null;
}
	@GetMapping("/checklogin")
	public Account checkLogin(String username, String password) {
		Account checklogin = accservice.checkLogin(username, password);
		if (checklogin != null) {
			return checklogin; 
	}
		return null;
}
}
