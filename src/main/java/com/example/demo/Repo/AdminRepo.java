package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Account;


@Repository
public interface AdminRepo extends JpaRepository<Account, Integer> {
	
	public List<Account> findByRole(String role);
	

}
