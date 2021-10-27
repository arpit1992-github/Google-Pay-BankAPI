package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dto.UPIFundTransferRespDto;
import com.bank.entity.Account;
import com.bank.entity.Transaction;
import com.bank.repo.AccountRepository;
import com.bank.repo.TransactionRepository;
import com.bank.utility.Utility;

@Service
@Transactional
public class UPIFundTransferServiceImpl implements UPIFundTransferService {

	@Autowired
	AccountRepository accRepo;
	
	@Autowired
	private TransactionRepository transRepo;

	private final Utility utile = new Utility();
	
	@Override
	public String fundTransferByMobile(double amount ,String toMobileNumber, String fromMobileNumber) {
		// TODO Auto-generated method stub
		
		Transaction t1 = new Transaction();
		Transaction t2 = new Transaction();
		Double fromAccountBal = 0.0;
		Double toAccountBal = 0.0;
		Account fromAccount = accRepo.findByRegMob(fromMobileNumber);
		Account toAccount = accRepo.findByRegMob(toMobileNumber);
		
		if(fromAccount.getAccountBalance()<amount) {
			return "insufficient amount";
		}else {
		
		fromAccountBal = fromAccount.getAccountBalance() - amount;
		t1.setAccountBalance(fromAccountBal);
		t1.setDebitAmount(amount);
		t1.setFromAccount(fromAccount.getAccountNumber());
		t1.setToAccount(toAccount.getAccountNumber());
		t1.setTransDate(utile.getCurrentLocalDate());
		t1.setTransID(utile.generateTransId());
		transRepo.save(t1);
		accRepo.updateAccount(fromAccountBal, fromAccount.getAccountNumber());

		toAccountBal = toAccount.getAccountBalance() + amount;
		t2.setAccountBalance(toAccountBal);
		t2.setCreditAmount(amount);
		t2.setFromAccount(fromAccount.getAccountNumber());
		t2.setToAccount(toAccount.getAccountNumber());
		t2.setTransDate(utile.getCurrentLocalDate());
		t2.setTransID(utile.generateTransId());
		transRepo.save(t2);

		accRepo.updateAccount(toAccountBal, toAccount.getAccountNumber());
		return "OK";
		}
	}

}
