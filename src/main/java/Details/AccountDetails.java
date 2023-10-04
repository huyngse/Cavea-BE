package Details;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import Entities.Accounts;

public class AccountDetails implements UserDetails{
	
	private Accounts acc;

	public AccountDetails(Accounts acc) {
		this.acc = acc;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = acc.getAuthorities();
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}
	
	public Accounts getAccount() {
		return acc;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return acc.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return acc.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	

}
