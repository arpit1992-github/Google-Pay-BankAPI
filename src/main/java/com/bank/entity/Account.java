package com.bank.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Account {

	@Id
	private String accountNumber;
	private String userId;
	private String accountType;
	private Double initialAmount;
	private String regEmail;
	private String regMob;
	private LocalDateTime createdDate;
	private Double accountBalance;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String accountNumber, String userId, String accountType, Double initialAmount, String regEmail,
			String regMob, LocalDateTime createdDate, Double accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.userId = userId;
		this.accountType = accountType;
		this.initialAmount = initialAmount;
		this.regEmail = regEmail;
		this.regMob = regMob;
		this.createdDate = createdDate;
		this.accountBalance = accountBalance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountBalance, accountNumber, accountType, createdDate, initialAmount, regEmail, regMob,
				userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accountBalance, other.accountBalance)
				&& Objects.equals(accountNumber, other.accountNumber) && Objects.equals(accountType, other.accountType)
				&& Objects.equals(createdDate, other.createdDate) && Objects.equals(initialAmount, other.initialAmount)
				&& Objects.equals(regEmail, other.regEmail) && Objects.equals(regMob, other.regMob)
				&& Objects.equals(userId, other.userId);
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getInitialAmount() {
		return initialAmount;
	}

	public void setInitialAmount(Double initialAmount) {
		this.initialAmount = initialAmount;
	}

	public String getRegEmail() {
		return regEmail;
	}

	public void setRegEmail(String regEmail) {
		this.regEmail = regEmail;
	}

	public String getRegMob() {
		return regMob;
	}

	public void setRegMob(String regMob) {
		this.regMob = regMob;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", userId=" + userId + ", accountType=" + accountType
				+ ", initialAmount=" + initialAmount + ", regEmail=" + regEmail + ", regMob=" + regMob
				+ ", createdDate=" + createdDate + ", accountBalance=" + accountBalance + "]";
	}

	
	
	
	
	
	
	
}
