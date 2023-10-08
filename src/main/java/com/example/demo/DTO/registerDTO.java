package com.example.demo.DTO;

public class registerDTO {
	private int account_id;
	private String username;
	private String password;
	private String email;
	private String firstname;
	private String lastname;
	private String phone;
	private String role;
	
	public registerDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public registerDTO(int account_id, String username, String password, String email, String firstname, String lastname,
			String phone, String role) {
		this.account_id = account_id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.role = role;
	}


	public int getAccount_Id() {
		return account_id;
	}
	public void setAccount_Id(int id) {
		this.account_id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
