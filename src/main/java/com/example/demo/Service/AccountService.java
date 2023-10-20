package com.example.demo.Service;

import java.util.List;

import java.util.Optional;
import java.util.UUID;

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

	public Account checkLogin(String username, String password) {
		return accrepo.checkLogin(username, password);
	}
	
	public Account getAccountByUserName(String username) {
		return accrepo.getAccountByUserName(username);
	}

	// public Account register (int id, String username, String password, String
	// email, String firstname, String lastname, String phone, String role) {
	// return accrepo.register(id, username, password, email, firstname, lastname,
	// phone, role);
	// }
	public Account getUsernameorEmail(String username, String email) {
		return accrepo.getUsernameOrEmail(username, email);
	}

	public Account register(registerDTO registerDTO) {
		String username = registerDTO.getUsername();
		String email = registerDTO.getEmail();
		if (accrepo.getUsernameorEmail(username) != null) {
			throw new RuntimeException("Username đã trùng");
		}
		if (accrepo.getUsernameorEmail(email) != null) {
			throw new RuntimeException("Email đã trùng");
		}
		String token = UUID.randomUUID().toString();
		Account account = new Account();
		account.setUsername(username);
		account.setPassword(registerDTO.getPassword());
		account.setEmail(email);
		account.setFirstName(registerDTO.getFirstName());
		account.setLastName(registerDTO.getLastName());
		account.setPhone(registerDTO.getPhone());
		account.setRole("customer");
		account.setToken(token);
		account.setEnable(false);
		return accrepo.save(account);
	}
	
	public Account updateAccount(String id, registerDTO DTO) {
		Account accupdate = accrepo.getAccountByID(id);
		if (accupdate == null) {
			throw new RuntimeException("DM may nha");
		}
		// if (accupdate == null) {
		// return null;
		// }
		// String email = DTO.getEmail();
		// if (accrepo.getUsernameorEmail(email) != null) {
		// return null;
		// }
		accupdate.setUsername(DTO.getUsername());
		accupdate.setPassword(DTO.getPassword());
		accupdate.setEmail(DTO.getEmail());
		accupdate.setFirstName(DTO.getFirstName());
		accupdate.setLastName(DTO.getLastName());
		accupdate.setPhone(DTO.getPhone());
		accupdate.setRole(DTO.getRole());
		return accrepo.save(accupdate);
	}

	public void deleted(int id) {
		Optional<Account> acc = accrepo.findById(id);
		if (acc != null) {
			Account account = acc.get();
			account.setEnable(false);
			accrepo.save(account);
		} else {
			throw new RuntimeException("Lỗi của Deleted");
		}
	}
	
	public void setEnable(String token) {
		Optional<Account> acc = accrepo.getAccountByToken(token);
		if(acc != null) {
			Account account = acc.get();
			account.setEnable(true);
			accrepo.save(account);
		}else {
			throw new RuntimeException("Token không hợp lệ");
		}
	}
	
	public void setNewPassWord(String token, String newPassword) {
		Optional<Account> account = accrepo.getAccountByToken(token);
		if(account == null) {
			throw new RuntimeException("Token not match");
		}
		Account acc = account.get();
		acc.setPassword(newPassword);
		accrepo.save(acc);
	}
}
