package Entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts", schema ="sales")

public class Accounts {
	@Id
	@Column(name ="account_id")
	private int id;
	@Column(name ="first_name")
	private String firstname;
	@Column(name= "last_name")
	private String lastname;
	@Column(name="phone")
	private String phone;
	@Column(name="email")
	private String email;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="role")
	private String role;
	@Column(name="reset_password_token")
	private UUID restpasswordtoken;
	
	public Accounts() {
		// TODO Auto-generated constructor stub
	}
	
	public Accounts(int id, String firstname, String lastname, String phone, String email, String username,
			String password, String role, UUID restpasswordtoken) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
		this.restpasswordtoken = restpasswordtoken;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UUID getRestpasswordtoken() {
		return restpasswordtoken;
	}
	public void setRestpasswordtoken(UUID restpasswordtoken) {
		this.restpasswordtoken = restpasswordtoken;
	}
	public String getAuthorities() {
		return role;
	}
	
	
	
}
