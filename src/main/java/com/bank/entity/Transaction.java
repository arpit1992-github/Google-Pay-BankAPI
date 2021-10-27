package com.bank.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Transaction {

	@Id
	private String transID;
	private String fromAccount;
	private String toAccount;
	private Double creditAmount;
	private Double debitAmount;
	private Double accountBalance;
	private LocalDateTime transDate;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(String transID, String fromAccount, String toAccount, Double creditAmount, Double debitAmount,
			Double accountBalance, LocalDateTime transDate) {
		super();
		this.transID = transID;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.creditAmount = creditAmount;
		this.debitAmount = debitAmount;
		this.accountBalance = accountBalance;
		this.transDate = transDate;
	}

	public String getTransID() {
		return transID;
	}

	public void setTransID(String transID) {
		this.transID = transID;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public Double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public Double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(Double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public LocalDateTime getTransDate() {
		return transDate;
	}

	public void setTransDate(LocalDateTime transDate) {
		this.transDate = transDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountBalance, creditAmount, debitAmount, fromAccount, toAccount, transDate, transID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(accountBalance, other.accountBalance) && Objects.equals(creditAmount, other.creditAmount)
				&& Objects.equals(debitAmount, other.debitAmount) && Objects.equals(fromAccount, other.fromAccount)
				&& Objects.equals(toAccount, other.toAccount) && Objects.equals(transDate, other.transDate)
				&& Objects.equals(transID, other.transID);
	}

	@Override
	public String toString() {
		return "Transaction [transID=" + transID + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount
				+ ", creditAmount=" + creditAmount + ", debitAmount=" + debitAmount + ", accountBalance="
				+ accountBalance + ", transDate=" + transDate + "]";
	}
	
	
}
