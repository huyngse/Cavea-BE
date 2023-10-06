package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DTO.AutheUserRequest;
import DTO.registerDTO;
import Entities.Accounts;
import Service.AccountService;
import repository.AccountReponse;


@RestController
@RequestMapping("/auth")
public class authController {
	@Autowired
	private AuthenticationManager authenManager;
	@Autowired
	private AccountReponse accReponse;
	@Autowired
	private AccountService accService;
	
	@PostMapping("/login")
	public Accounts login(@RequestBody AutheUserRequest loginDTO) {
		String username = loginDTO.getUsername();
		String password = loginDTO.getPassword();
		System.out.print(username + ": " +  password);
		Authentication auth = authenManager.authenticate(
				new UsernamePasswordAuthenticationToken(username, password));
		Accounts user = accReponse.getUsernameorEmail(username);
		return user;
	}
	@PostMapping("/register")
	public Accounts register(@RequestBody registerDTO registerDTO) {
		Accounts user = accService.register(registerDTO);
		if(user == null) {
			throw new RuntimeException(" Can not sign up for the data!!!");
		}
		return user;
	}
	@PostMapping("/register/error/username")
	public boolean registercheckExiUser(@RequestParam String username) {
		if(accService.checkExistUserOrEmail(username)) {
			throw new RuntimeException("Exist Username !!");
		}
		return true;
	}
	@PostMapping("/register/error/email")
	public boolean registercheckExiEmail(@RequestParam String email) {
		if(accService.checkExistUserOrEmail(email)) {
			throw new RuntimeException("Exist Email !!");
		}
		return true;
	}
}
