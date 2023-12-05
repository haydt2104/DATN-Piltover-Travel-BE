package com.piltover.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.piltover.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	@Query("SELECT a FROM Account a WHERE a.isDelete = false")
    List<Account> findAllActiveAccounts();
	
	@Query("SELECT a.email FROM Account a")
	List<String> getAllEmails();

	@Query("SELECT a.phone FROM Account a")
	List<String> getAllPhones();
	
	@Query("SELECT a FROM Account a WHERE a.email = :email")
    Optional<Account> findByEmail(@Param("email") String email);
	
	@Query("SELECT a.id FROM Account a WHERE a.email = ?1")
	Long findIdByEmail(String email);
}
