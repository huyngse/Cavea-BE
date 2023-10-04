package Service;


import DTO.userProfileDTO;
import Entities.Accounts;
import Responese.AccountReponse;

public class AccountService {
	
	AccountReponse accrepositive;
	final String DEFAULT_PASSWORD = "$2a$10$eiGJNzsBj.TKTG72BRRMteJlOIBv9x3KoaTAbzYKaX652FUB17pzG";
	
	public Accounts GetUsernameorEmail(String username) {
		return accrepositive.getUsernameorEmail(username);
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
}
