package br.com.calcard.credit.domain;

public enum MaritalStatus {
	
	MARRIED("Casado(a)"),
	SINGLE("Solteiro(a)"),
	DIVORCED("Divorciado(a)"),
	WIDOWED("Viúvo(a)");
	
	private String relationship;
	
	MaritalStatus(String relationship) {
		this.relationship = relationship;
	}
	
	public String getRelationshipDescription() {
		return relationship;
	}

}
