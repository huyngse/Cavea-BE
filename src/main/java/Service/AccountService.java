package Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import DTO.registerDTO;
import DTO.userProfileDTO;

import Entities.Accounts;
import Repository.AccountReponse;

@Service
public class AccountService {
	
	AccountReponse accrepositive;
	final String DEFAULT_PASSWORD = "$2a$10$eiGJNzsBj.TKTG72BRRMteJlOIBv9x3KoaTAbzYKaX652FUB17pzG";
	
	public Accounts GetUsernameorEmail(String username) {
		return accrepositive.getUsernameorEmail(username);
	}
	
	public Accounts GetUserbyEmail(String email) {
		return accrepositive.getEmail(email);
	}
	
	public Accounts updateUserProfileDTO(String userEmail, userProfileDTO userDTO) {
		if (accrepositive.getUsernameorEmail(userEmail) == null) {
			throw new RuntimeException("Email Not Exist!!!");
			
		}
		Accounts user = accrepositive.getUsernameorEmail(userEmail);
		
			user.setUsername(userDTO.getUsername());
			user.setPassword(DEFAULT_PASSWORD);
			user.setFirstname(userDTO.getFirstName());
			user.setLastname(userDTO.getLastName());
			user.setPhone(userDTO.getPhone());
			accrepositive.save(user);
		
		return user;
	}
	
	@Autowired
	PasswordEncoder passwordEncorder;
	public Accounts register(registerDTO registerDTO) {
		String username = registerDTO.getUsername();
		String email = registerDTO.getEmail();
		
		if(accrepositive.getUsernameorEmail(username) != null) {
			return null;
		}
		if(accrepositive.getUsernameorEmail(email) != null) {
			return null;
		}
		
		Accounts user = new Accounts();
		user.setUsername(username);
		user.setEmail(email);
		user.setFirstname(registerDTO.getFirstName());
		user.setLastname(registerDTO.getLastName());
		user.setRole(registerDTO.getRole());
		return accrepositive.save(user);
	}
	
	public boolean checkExistUserOrEmail(String check) {
		if(accrepositive.getUsernameorEmail(check) == null) {
			return false;
		}
		return true;
	}
}
