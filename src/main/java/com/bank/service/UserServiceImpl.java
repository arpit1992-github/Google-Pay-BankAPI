package com.bank.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dto.UserRequestDto;
import com.bank.entity.Account;
import com.bank.entity.User;
import com.bank.repo.AccountRepository;
import com.bank.repo.TransactionRepository;
import com.bank.repo.UserRepository;
import com.bank.utility.Utility;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private UserRepository userRepo;

	private final Utility utile = new Utility();

	@Override
	public String createUserAccount(UserRequestDto userReq) {
		String accountNumber = null;
		User pancard = userRepo.findByPanNo(userReq.getPanNo());
		User mobNumber = userRepo.findByRegMobNum(userReq.getRegMobNum());
		if (pancard != null || mobNumber !=null) {
			return "User already exist";
		} else {
			User user = new User();
			String userId = utile.generateUserId();
			BeanUtils.copyProperties(userReq, user);
			user.setUserId(userId);
			user.setCreatedDate(utile.getCurrentLocalDate());
			user.setDob(userReq.getDob());
			userRepo.save(user);

			Account account = new Account();
			accountNumber = utile.generateAccountNumber();
			account.setAccountNumber(accountNumber);
			account.setAccountType("saving");
			account.setCreatedDate(utile.getCurrentLocalDate());
			account.setInitialAmount(100000.00);
			account.setRegEmail(userReq.getRegEmail());
			account.setRegMob(userReq.getRegMobNum());
			account.setAccountBalance(100000.00);
			account.setUserId(userId);
			accountRepo.save(account);
		}
		return "Account Created Successfully ,Your account number is :: " + accountNumber;
	}

	@Override
	public boolean checkUserRegMob(String mobNumber) {
		
		return false;
	}
	
}
