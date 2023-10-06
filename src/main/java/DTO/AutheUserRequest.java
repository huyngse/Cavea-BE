package DTO;

public class AutheUserRequest {
	private String username;
	private String password;
	
	public AutheUserRequest() {
		// TODO Auto-generated constructor stub
	}

	public AutheUserRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
