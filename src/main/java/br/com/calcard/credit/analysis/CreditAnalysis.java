package br.com.calcard.credit.analysis;

import java.math.BigDecimal;

import br.com.calcard.credit.domain.MaritalStatus;

public class CreditAnalysis implements Credible {

	private Integer age;
	private MaritalStatus maritalStatus;
	private Integer numberOfDependent;
	private BigDecimal income;

	public CreditAnalysis(Integer age, MaritalStatus maritalStatus, Integer numberOfDependent, BigDecimal income) {
		this.age = age;
		this.maritalStatus = maritalStatus;
		this.numberOfDependent = numberOfDependent;
		this.income = income;
	}

	public Boolean creditAproved() {
		return true;
	}

	public String feedbackTextAnalysis() {
		return null;
	}

}
