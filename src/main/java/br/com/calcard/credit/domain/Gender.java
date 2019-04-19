package br.com.calcard.credit.domain;

public enum Gender {
	
	MALE("Masculino"),
	FEMALE("Feminino");
	
	private String genderDescription;
	
	Gender(String genderDescription) {
		this.genderDescription = genderDescription;
	}
	
	public String getGenderDescription() {
		return genderDescription;
	}

}
