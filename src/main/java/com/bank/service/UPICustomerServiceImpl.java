package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.User;
import com.bank.repo.UserRepository;

@Service
public class UPICustomerServiceImpl implements UPICustomerService {

	@Autowired
	UserRepository userRepo;
	@Override
	public boolean checkUserRegMob(String mobNumber) {
		User user=userRepo.findByRegMobNum(mobNumber);
		return  user!=null?true:false;
	}

	
}
