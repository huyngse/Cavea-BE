package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.Entities.Account;
import com.example.demo.Service.AccountService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/login")
@CrossOrigin("http://localhost:3000")
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

	@PostMapping("/checklogin")
	public ResponseEntity<?> checkLogin(@RequestBody LoginDTO loginDTO) {
		String username = loginDTO.getUsername();
		String password = loginDTO.getPassword();
		Account checklogin = accservice.checkLogin(username, password);
		if (checklogin != null) {
			return ResponseEntity.ok(checklogin);
		} else {
			return ResponseEntity.badRequest().body("Incorrect username or password");
		}
	}
}
