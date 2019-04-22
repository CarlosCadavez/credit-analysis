package br.com.calcard.credit.domain;

public enum Gender {
	
	MALE("M"),
	FEMALE("F");
	
	private String genderDescription;
	
	Gender(String genderDescription) {
		this.genderDescription = genderDescription;
	}
	
	public String getGenderDescription() {
		return genderDescription;
	}

}
