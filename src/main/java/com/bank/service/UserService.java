package com.bank.service;


import com.bank.dto.UserRequestDto;

public interface UserService {

	 public String createUserAccount(UserRequestDto userReq);

	public boolean checkUserRegMob(String mobNumber);
	 
}
