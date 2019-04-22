package br.com.calcard.credit.analysis;

import java.math.BigDecimal;

import br.com.calcard.credit.domain.MaritalStatus;

public interface SendableData {
	
	Integer getAge();
	MaritalStatus getMaritalStatus();
	Integer getNumberOfDependent();
	BigDecimal getIncome();

}
