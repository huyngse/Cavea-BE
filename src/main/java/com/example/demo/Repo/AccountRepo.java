package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {
	
	@Query( value = "select * from sales.accounts acc where acc.username = :username or acc.email = :username", nativeQuery = true)
	public Account getUsernameorEmail(@Param("username") String username);
	
	@Query(value = "select * from sales.accounts where username = :username and password = :password or email = :username and password = :password", nativeQuery = true)
	public Account checkLogin(@Param("username") String username, @Param("password") String password);
	
//	@Query(value = "insert into sales.accounts (account_id,username, password, email, first_name, last_name, phone, role)\r\n"
//			+ "values(:id,:username, :password, :email, :firstname, :lastname, :phone, :role)", nativeQuery = true)
//	public Account register(@Param("id") int id, @Param("username") String username, @Param("password") String password, @Param("email") String email,
//			@Param("firstname") String firstname, @Param("lastname") String lastname, @Param("phone") String phone, @Param("role") String role);
	@Query(value = "select * from sales.accounts where username = :username or email like :email", nativeQuery = true)
	public Account getUsernameOrEmail(@Param("username") String username, @Param("email") String email);
	
	@Query(value = "select MAX(account_id) FROM sales.accounts" ,nativeQuery = true)
	public int getAccountID();
}


