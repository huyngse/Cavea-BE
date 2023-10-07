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
}
