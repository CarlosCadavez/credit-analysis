package br.com.calcard.credit.domain;

public enum MaritalStatus {
	
	MARRIED("Casada(o)"),
	SINGLE("Solteira(o)"),
	DIVORCED("Divorciada(o)"),
	WIDOWED("Viúva(o)");
	
	private String relationship;
	
	MaritalStatus(String relationship) {
		this.relationship = relationship;
	}
	
	public String getRelationshipDescription() {
		return relationship;
	}

}
