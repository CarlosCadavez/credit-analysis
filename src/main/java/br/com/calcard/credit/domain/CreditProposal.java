package br.com.calcard.credit.domain;

import java.math.BigDecimal;

public class CreditProposal {

	private String name;
	private String cpf;
	private Integer age;
	private Gender gender;
	private MaritalStatus maritalStatus;
	private String state;
	private Integer numberOfDependent;
	private BigDecimal income;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getNumberOfDependent() {
		return numberOfDependent;
	}

	public void setNumberOfDependent(Integer numberOfDependent) {
		this.numberOfDependent = numberOfDependent;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

}
