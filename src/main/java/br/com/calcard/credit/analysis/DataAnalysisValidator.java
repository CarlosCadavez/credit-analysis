package br.com.calcard.credit.analysis;

import org.springframework.util.ObjectUtils;

import br.com.calcard.credit.analysis.exception.RequiredDataNotFoundedToAnalysis;

public class DataAnalysisValidator {

	private SendableData dataAnalysis;

	public DataAnalysisValidator(SendableData dataAnalysis) {
		this.dataAnalysis = dataAnalysis;
	}

	public void valid() {
		if (ObjectUtils.isEmpty(dataAnalysis.getAge())) {
			throw new RequiredDataNotFoundedToAnalysis("Age value not found");
		}
		
		if (ObjectUtils.isEmpty(dataAnalysis.getIncome())) {
			throw new RequiredDataNotFoundedToAnalysis("Income value not found");
		}
		
		if (ObjectUtils.isEmpty(dataAnalysis.getMaritalStatus())) {
			throw new RequiredDataNotFoundedToAnalysis("Marital status value not found");
		}
		
		if (ObjectUtils.isEmpty(dataAnalysis.getNumberOfDependent())) {
			throw new RequiredDataNotFoundedToAnalysis("Number of dependents value not found");
		}
	}

}
