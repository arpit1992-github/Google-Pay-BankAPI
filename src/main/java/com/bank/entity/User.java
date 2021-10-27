package com.bank.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
	@Id
	private String userId;
	private String firstName;
	private String lastName;
	private String panNo;
	private String regMobNum;
	private String regEmail;
	private String address;
	private LocalDateTime createdDate;
	private LocalDate dob;
	private String gender;
	private int age;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	

	public User(String userId, String firstName, String lastName, String panNo, String regMobNum, String regEmail,
			String address, LocalDateTime createdDate, LocalDate dob, String gender, int age) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.panNo = panNo;
		this.regMobNum = regMobNum;
		this.regEmail = regEmail;
		this.address = address;
		this.createdDate = createdDate;
		this.dob = dob;
		this.gender = gender;
		this.age = age;
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getRegMobNum() {
		return regMobNum;
	}

	public void setRegMobNum(String regMobNum) {
		this.regMobNum = regMobNum;
	}

	public String getRegEmail() {
		return regEmail;
	}

	public void setRegEmail(String regEmail) {
		this.regEmail = regEmail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, age, createdDate, dob, firstName, gender, lastName, panNo, regEmail, regMobNum,
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
		User other = (User) obj;
		return Objects.equals(address, other.address) && age == other.age
				&& Objects.equals(createdDate, other.createdDate) && Objects.equals(dob, other.dob)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(gender, other.gender)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(panNo, other.panNo)
				&& Objects.equals(regEmail, other.regEmail) && Objects.equals(regMobNum, other.regMobNum)
				&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", panNo=" + panNo
				+ ", regMobNum=" + regMobNum + ", regEmail=" + regEmail + ", address=" + address + ", createdDate="
				+ createdDate + ", dob=" + dob + ", gender=" + gender + ", age=" + age + "]";
	}

	
	
	
	
	

	
	
}
