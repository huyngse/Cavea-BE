package Responese;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Entities.Accounts;

public interface AccountReponse extends JpaRepository<Accounts, String>{
	
	@Query("select * from sales.accounts acc where acc.username like = :username or acc.email like = :username")
	public Accounts getUsernameorEmail(@Param("username") String username);
}
