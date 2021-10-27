package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dto.FundTransferRequestDto;
import com.bank.entity.Account;
import com.bank.entity.Transaction;
import com.bank.repo.AccountRepository;
import com.bank.repo.TransactionRepository;
import com.bank.repo.UserRepository;
import com.bank.utility.Utility;

@Service
@Transactional
public class FundTransferServiceImpl implements FundTransferService {

	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private TransactionRepository transRepo;
	

	private final Utility utile = new Utility();
	
	@Override
	public String fundTransfer(FundTransferRequestDto fundTransReq) {
		Transaction t1 = new Transaction();
		Transaction t2 = new Transaction();
		
		Double fromAccountBal = 0.0;
		Double toAccountBal = 0.0;
		Account fromAccount = accountRepo.findByAccountNumber(fundTransReq.getFromAccountNumber()).get(0);
		if (fromAccount.getAccountNumber() == null)
			return "From Account is not exist";
		Account toAccount = accountRepo.findByAccountNumber(fundTransReq.getToAccountNumber()).get(0);
		if (toAccount.getAccountNumber() == null)
			return "To Account is not exist";

		
		
		fromAccountBal = fromAccount.getAccountBalance() - fundTransReq.getAmount();
		t1.setAccountBalance(fromAccountBal);
		t1.setDebitAmount(fundTransReq.getAmount());
		t1.setFromAccount(fundTransReq.getFromAccountNumber());
		t1.setToAccount(fundTransReq.getToAccountNumber());
		t1.setTransDate(utile.getCurrentLocalDate());
		t1.setTransID(utile.generateTransId());
		transRepo.save(t1);
		accountRepo.updateAccount(fromAccountBal, fundTransReq.getFromAccountNumber());

		toAccountBal = toAccount.getAccountBalance() + fundTransReq.getAmount();
		t2.setAccountBalance(toAccountBal);
		t2.setCreditAmount(fundTransReq.getAmount());
		t2.setFromAccount(fundTransReq.getFromAccountNumber());
		t2.setToAccount(fundTransReq.getToAccountNumber());
		t2.setTransDate(utile.getCurrentLocalDate());
		t2.setTransID(utile.generateTransId());
		transRepo.save(t2);

		accountRepo.updateAccount(toAccountBal, fundTransReq.getToAccountNumber());
		return "Transaction completed Successfully";
	}

}
