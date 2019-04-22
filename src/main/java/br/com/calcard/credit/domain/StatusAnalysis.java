package br.com.calcard.credit.domain;

public enum StatusAnalysis {
	
	APROVED("Aprovado"),
	DISAPROVED("Negado");
	
	private String statusAnalysisDescription;
	
	StatusAnalysis(String statusAnalysisDescription) {
		this.statusAnalysisDescription = statusAnalysisDescription;
	}
	
	public String getGenderDescription() {
		return statusAnalysisDescription;
	}

}
