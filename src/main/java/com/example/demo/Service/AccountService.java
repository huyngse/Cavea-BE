package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.registerDTO;
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
	
//	public Account register (int id, String username, String password, String email, String firstname, String lastname, String phone, String role) {
//		return accrepo.register(id, username, password, email, firstname, lastname, phone, role);
//	}
	public Account getUsernameorEmail(String username, String email) {
		return accrepo.getUsernameOrEmail(username, email);
	}
	public Account register(registerDTO registerDTO) {
		String username = registerDTO.getUsername();
		String email = registerDTO.getEmail();
		if(accrepo.getUsernameorEmail(username) != null ) {
			return null;
		}
		if(accrepo.getUsernameorEmail(email) != null) {
			return null;
		}
		Account account = new Account();
		account.setUsername(username);
		account.setPassword(registerDTO.getPassword());
		account.setEmail(email);
		account.setFirstName(registerDTO.getFirstname());
		account.setLastName(registerDTO.getLastname());
		account.setPhone(registerDTO.getPhone());
		account.setRole("customer");
		
		return accrepo.save(account);
	}

}
