package br.com.calcard.credit.builder;

import java.math.BigDecimal;

import br.com.calcard.credit.analysis.SendableData;
import br.com.calcard.credit.domain.MaritalStatus;

public class DataAnalysisBuilder {
	
	private DataToAnalyse dataToAnalyse;
	
	public DataAnalysisBuilder() {
		dataToAnalyse = new DataToAnalyse();
	}

	public DataAnalysisBuilder withUserAge(Integer age) {
		dataToAnalyse.setAge(age);
		return this;
	}

	public DataAnalysisBuilder withUserMaritalStatus(MaritalStatus maritalStatus) {
		dataToAnalyse.setMaritalStatus(maritalStatus);
		return this;
	}

	public DataAnalysisBuilder withUserNumberDependents(Integer numberDependent) {
		dataToAnalyse.setNumberOfDependent(numberDependent);
		return this;
	}

	public DataAnalysisBuilder withUserIncome(BigDecimal income) {
		dataToAnalyse.setIncome(income);
		return this;
	}

	public DataToAnalyse build() {
		return dataToAnalyse;
	}

	class DataToAnalyse implements SendableData {

		private Integer age;
		private MaritalStatus maritalStatus;
		private Integer numberOfDependent;
		private BigDecimal income;

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
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

		public MaritalStatus getMaritalStatus() {
			return maritalStatus;
		}

		public void setMaritalStatus(MaritalStatus maritalStatus) {
			this.maritalStatus = maritalStatus;
		}


	}

}
