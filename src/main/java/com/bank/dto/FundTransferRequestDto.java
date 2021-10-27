package com.bank.dto;


import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class FundTransferRequestDto {
	//@Size(min=1)
	//@NotEmpty
	private Double amount;
	//@NotEmpty
	private String fromAccountNumber;
	//@NotEmpty
	private String toAccountNumber;
	
	public FundTransferRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public String getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public FundTransferRequestDto(Double amount, String fromAccountNumber, String toAccountNumber) {
		super();
		this.amount = amount;
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
	}

	@Override
	public String toString() {
		return "FundTransferRequestDto [amount=" + amount + ", fromAccountNumber=" + fromAccountNumber
				+ ", toAccountNumber=" + toAccountNumber + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, fromAccountNumber, toAccountNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FundTransferRequestDto other = (FundTransferRequestDto) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(fromAccountNumber, other.fromAccountNumber)
				&& Objects.equals(toAccountNumber, other.toAccountNumber);
	}

	
	
	
	
}
