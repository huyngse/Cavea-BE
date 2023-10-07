package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Account;
import com.example.demo.Repo.AccountRepo;

@Service
public class AccountService {
	@Autowired
	private AccountRepo accrepo;
	
	public Account getUSernameorEmail(String username) {
		return accrepo.getUsernameorEmail(username);
	}
	
	public Account checkLogin (String username, String password) {
		return accrepo.checkLogin(username, password);
	}
	
	public Account register (int id, String username, String password, String email, String firstname, String lastname, String phone, String role) {
		return accrepo.register(id, username, password, email, firstname, lastname, phone, role);
	}

}
