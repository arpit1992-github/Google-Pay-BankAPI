package com.bank.dto;

import java.util.Objects;

public class UPIAmountDto {

	private Double amount;
	
	public UPIAmountDto() {
		// TODO Auto-generated constructor stub
	}

	public UPIAmountDto(Double amount) {
		super();
		this.amount = amount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UPIAmountDto other = (UPIAmountDto) obj;
		return Objects.equals(amount, other.amount);
	}

	@Override
	public String toString() {
		return "UPIAmountDto [amount=" + amount + "]";
	}
	
	 
	
}
