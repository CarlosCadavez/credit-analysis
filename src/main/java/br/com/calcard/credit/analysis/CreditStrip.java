package br.com.calcard.credit.analysis;

public enum CreditStrip {
	
	LOW_INCOME(Double.valueOf("0"), Double.valueOf("0")),
	FIRST(Double.valueOf("100"), Double.valueOf("500")),
	SECOND(Double.valueOf("500"), Double.valueOf("1000")),
	THIRD(Double.valueOf("1000"), Double.valueOf("1500")),
	FOURTH(Double.valueOf("1500"), Double.valueOf("2000")),
	GREATHER_THAN_TWO_THOUSAND(Double.valueOf("2000"), Double.valueOf("2000"));
	
    private Double limitInit;
    private Double limitFinal;
	
    CreditStrip(Double limitInit, Double limitFinal) {
		this.limitInit = limitInit;
		this.limitFinal = limitFinal;
	}

	public Double getLimitInit() {
		return limitInit;
	}

	public Double getLimitFinal() {
		return limitFinal;
	}
	

}
