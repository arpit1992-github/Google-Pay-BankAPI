package com.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dto.BankStatementDto;
import com.bank.entity.Transaction;
import com.bank.repo.AccountRepository;
import com.bank.repo.TransactionRepository;
import com.bank.repo.UserRepository;
import com.bank.utility.Utility;

@Service
@Transactional
public class BankStatementServiceImpl implements BankStatementService {

	
	@Autowired
	private TransactionRepository transRepo;
	

	private final Utility utile = new Utility();

	@Override
	public List<BankStatementDto> getBankStatement(String date, String userAccount) {
		List<BankStatementDto> bankStatementList = new ArrayList<>();
		List<Transaction> findByTransDateBetween = null;
		List<String> dateList = null;
		String interval = date.toUpperCase();
		String[] tokens = interval.split("-");
		String month = tokens[0];
		//System.out.println(month);
		
		String year = tokens[1];
		
		dateList = utile.getFromDateToDate(utile.getMonth(month), year);

	
		findByTransDateBetween = transRepo.getBankStatments(userAccount, utile.getMonth(month), Integer.parseInt(year));
		
		for (Transaction transaction : findByTransDateBetween) {
			
			BankStatementDto bankStatementDto = new BankStatementDto();
			BeanUtils.copyProperties(transaction, bankStatementDto);
				bankStatementList.add(bankStatementDto);
		}
		return bankStatementList;
	}
}
