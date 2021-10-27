package com.bank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bank.entity.Account;


public interface AccountRepository extends JpaRepository<Account,String> {

	public List<Account> findByAccountNumber(String accountNumber);
	
	 @Modifying
	 @Query("UPDATE Account c SET c.accountBalance = :accountBalance WHERE c.accountNumber = :accountNumber")
	 public void  updateAccount(Double accountBalance,@Param("accountNumber") String accountNumber);

	 public Account findByRegMob(String mobNumber);
}
