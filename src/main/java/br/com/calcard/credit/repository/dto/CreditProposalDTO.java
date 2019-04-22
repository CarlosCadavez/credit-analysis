package br.com.calcard.credit.repository.dto;

import java.math.BigDecimal;

import br.com.calcard.credit.domain.Gender;
import br.com.calcard.credit.domain.MaritalStatus;
import br.com.calcard.credit.domain.StatusAnalysis;

public class CreditProposalDTO {

	public CreditProposalDTO(String name, Integer age, Gender gender, MaritalStatus maritalStatus, String state,
			Integer numberOfDependent, BigDecimal income, StatusAnalysis statusAnalysis) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.state = state;
		this.numberOfDependent = numberOfDependent;
		this.income = income;
		this.statusAnalysis = statusAnalysis;
	}

	private String name;
	private Integer age;
	private Gender gender;
	private MaritalStatus maritalStatus;
	private String state;
	private Integer numberOfDependent;
	private BigDecimal income;
	private StatusAnalysis statusAnalysis;

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public String getGender() {
		return gender.getGenderDescription();
	}

	public String getMaritalStatus() {
		return maritalStatus.getRelationshipDescription();
	}

	public String getState() {
		return state;
	}

	public Integer getNumberOfDependent() {
		return numberOfDependent;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public String getStatusAnalysis() {
		return statusAnalysis.getGenderDescription();
	}
	
}
