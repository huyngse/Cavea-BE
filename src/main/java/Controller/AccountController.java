package Controller;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DTO.userProfileDTO;
import Entities.Accounts;
import Service.AccountService;
import Utils.SecurityUltis;


@RestController
@RequestMapping("/account")
public class AccountController {
	
	AccountService accservice;
	@GetMapping()
	public Accounts getUser() {
		Accounts user = SecurityUltis.getPrincipal().getAccount();
		String email = user.getEmail();
		return accservice.GetUsernameorEmail(email);
	}
	@PutMapping("/{username}")
	public Accounts updateUserDTO(@PathVariable String username, @RequestBody userProfileDTO userRequestDTO) throws NotFoundException {
		Accounts currentUser = SecurityUltis.getPrincipal().getAccount();
		Accounts reqUser = accservice.GetUsernameorEmail(username);
		if (currentUser == null)
			throw new RuntimeException("401 Unauthorized!!!!");
		
		if ((currentUser.getUsername().toLowerCase().equals(username.toLowerCase()) == false) 
				&& currentUser.getId() != 3
				&& !(currentUser.getId() == 2 && reqUser.getId() == 1))
			throw new RuntimeException("401 Unauthorized!!!!");
		if (reqUser == null)
			throw new NotFoundException();
		Accounts user = accservice.updateUserProfileDTO(username, userRequestDTO);
		return user;
	}
	
	@GetMapping("/{username}")
	public Accounts getUserByUsername(@PathVariable String username) {
		Accounts currentUser = SecurityUltis.getPrincipal().getAccount();
		Accounts result = accservice.GetUsernameorEmail(username);
		if (currentUser == null || !(currentUser.getId() == 2 && result.getId() == 1))
			throw new RuntimeException("401 Unauthorized!!!!");
		System.out.print("fucl");
		return result;
	}
}
