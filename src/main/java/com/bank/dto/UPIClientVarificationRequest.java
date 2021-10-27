package com.bank.dto;

import java.util.Objects;

public class UPIClientVarificationRequest {
	private String firstName;
	private String lastName;
	private String mobileNumber;
	
	public UPIClientVarificationRequest() {
		// TODO Auto-generated constructor stub
	}

	public UPIClientVarificationRequest(String firstName, String lastName, String mobileNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, mobileNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UPIClientVarificationRequest other = (UPIClientVarificationRequest) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(mobileNumber, other.mobileNumber);
	}

	@Override
	public String toString() {
		return "UPIClientVarificationRequest [firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber="
				+ mobileNumber + "]";
	}
	
	
}
