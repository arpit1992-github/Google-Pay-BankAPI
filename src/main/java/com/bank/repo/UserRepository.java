package com.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	public User findByPanNo(String panNo);
	public User findByRegMobNum(String mobNumber);
}
