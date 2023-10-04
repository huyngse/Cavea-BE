package Utils;

import org.springframework.security.core.context.SecurityContextHolder;

import Details.AccountDetails;

public class SecurityUltis {
	public static AccountDetails getPrincipal() {
		return (AccountDetails) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
	}
}
