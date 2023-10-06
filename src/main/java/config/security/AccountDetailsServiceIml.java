package config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import Entities.Accounts;
import repository.AccountReponse;



public class AccountDetailsServiceIml implements UserDetailsService {
	@Autowired
	private AccountReponse accountreponse;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Accounts user = accountreponse.getUsernameorEmail(username);

		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}

		return new AccountDetails(user);
	}

}
