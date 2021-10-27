package com.bank.repo;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bank.entity.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction, String> {
	
	
	@Query("from Transaction where  month(transDate)=:month and year(transDate)=:year and fromAccount=:accountNo Or toAccount=:accountNo")
	List<Transaction> getBankStatments(@Param("accountNo")String accountNo, @Param("month")int month, @Param("year")int year);

	
}
