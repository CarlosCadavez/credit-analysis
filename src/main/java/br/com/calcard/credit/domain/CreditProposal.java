package br.com.calcard.credit.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.calcard.credit.analysis.SendableData;

@Entity
public class CreditProposal implements SendableData {

	private Long id;
	private String name;
	private String cpf;
	private Integer age;
	private Gender gender;
	private MaritalStatus maritalStatus;
	private String state;
	private Integer numberOfDependent;
	private BigDecimal income;
	private StatusAnalysis statusAnalysis;
	private String messageAnalysis;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotBlank
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

	@Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Enumerated(EnumType.STRING)
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

	@NotNull
	@DecimalMin("0")
	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	@Enumerated(EnumType.STRING)
	public StatusAnalysis getStatusAnalysis() {
		return statusAnalysis;
	}

	public void setStatusAnalysis(StatusAnalysis statusAnalysis) {
		this.statusAnalysis = statusAnalysis;
	}

	public String getMessageAnalysis() {
		return messageAnalysis;
	}

	public void setMessageAnalysis(String messageAnalysis) {
		this.messageAnalysis = messageAnalysis;
	}

}
