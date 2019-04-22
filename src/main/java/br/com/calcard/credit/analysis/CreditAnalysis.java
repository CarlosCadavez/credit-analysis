package br.com.calcard.credit.analysis;

import java.math.BigDecimal;

import br.com.calcard.credit.domain.MaritalStatus;

public class CreditAnalysis {
	
	private boolean creditAproved;
	private CreditStrip creditStrip;
	private String messageLimitFeedback;
	
	public void runAnalysis(SendableData dataAnalysis) {
		new DataAnalysisValidator(dataAnalysis).valid();
		
		if (isLowIncome(dataAnalysis.getIncome())) return;
		if (isHighIncome(dataAnalysis.getIncome(), dataAnalysis.getNumberOfDependent())) return;
		if (refusedByCompany(dataAnalysis.getIncome(), dataAnalysis.getNumberOfDependent(), dataAnalysis.getMaritalStatus())) return;

		setLimitStripByIncomeStrip(dataAnalysis);
		
	}

	private void setLimitStripByIncomeStrip(SendableData dataAnalysis) {
		boolean incomeStripIntermediate = dataAnalysis.getIncome().compareTo(new BigDecimal("5000")) >= 0 && dataAnalysis.getIncome().compareTo(new BigDecimal("8000")) < 0;
		
		if (incomeStripIntermediate && dataAnalysis.getNumberOfDependent() <= 3) {
			creditStrip = CreditStrip.THIRD;
			messageLimitFeedback = createMessage(creditStrip.getLimitInit(), creditStrip.getLimitFinal());
			creditAproved = true;
			return;
		}
		
		if (dataAnalysis.getIncome().compareTo(new BigDecimal("2500")) <= 0) {
			if (dataAnalysis.getNumberOfDependent() == 0) {
				creditStrip = CreditStrip.SECOND;
				messageLimitFeedback = createMessage(creditStrip.getLimitInit(), creditStrip.getLimitFinal());
				creditAproved = true;
			}
			else {
				creditStrip = CreditStrip.FIRST;
				messageLimitFeedback = createMessage(creditStrip.getLimitInit(), creditStrip.getLimitFinal());
				creditAproved = true;
			}
		}
		
		if (dataAnalysis.getIncome().compareTo(new BigDecimal("2000")) <= 0 
				&& dataAnalysis.getAge() < 20 
				&& dataAnalysis.getNumberOfDependent() == 0) {
			
			creditStrip	= CreditStrip.FIRST;
			messageLimitFeedback = createMessage(creditStrip.getLimitInit(), creditStrip.getLimitFinal());
			creditAproved = true;
		}
		
	}

	private boolean refusedByCompany(BigDecimal income, Integer numberOfDependent, MaritalStatus maritalStatus) {
		boolean maritalStatusVerify = maritalStatus.equals(MaritalStatus.DIVORCED) || maritalStatus.equals(MaritalStatus.WIDOWED);
		
		if (maritalStatusVerify && numberOfDependent <= 3) {
			creditStrip = CreditStrip.LOW_INCOME;
			messageLimitFeedback = creditDisaproved();
			creditAproved = false;
			return true;
		}
		
		return false;
	}

	private boolean isHighIncome(BigDecimal income, Integer numberOfDependent) {
		if (income.compareTo(new BigDecimal("8000")) >= 0) {
			if (numberOfDependent > 3) {
				creditStrip = CreditStrip.THIRD;
				messageLimitFeedback = createMessage(creditStrip.getLimitInit(), creditStrip.getLimitFinal());
				creditAproved = true;
			} else if (numberOfDependent < 3) {
				creditStrip = CreditStrip.GREATHER_THAN_TWO_THOUSAND;
				messageLimitFeedback = createMessageMaxCredit();
				creditAproved = true;
			}
			else {
				creditStrip = CreditStrip.FOURTH;
				messageLimitFeedback = createMessage(creditStrip.getLimitInit(), creditStrip.getLimitFinal());
				creditAproved = true;
			}
			return true;
		}
		
		return false;
	}

	private boolean isLowIncome(BigDecimal income) {
		
		if (income.compareTo(new BigDecimal("500")) <= 0) {
			creditStrip = CreditStrip.LOW_INCOME;
			messageLimitFeedback = createMessageLowIncome();
			creditAproved = false;
			return true;
		}
		
		return false;
		
	}

	private String createMessage(Double startLimit, Double endLimit) {
		return String.format("entre %s - %s", startLimit.intValue(), endLimit.intValue());
	}

	public boolean creditIsAproved() {
		return creditAproved;
	}

	public String getMessageLimitFeedback() {
		return messageLimitFeedback;
	}

	public CreditStrip getCreditStrip() {
		return creditStrip;
	}

	public void setCreditStrip(CreditStrip creditStrip) {
		this.creditStrip = creditStrip;
	}
	
	private String creditDisaproved() {
		return "reprovado pela política de crédito";
	}

	private String createMessageMaxCredit() {
		return "superior 2000";
	}

	private String createMessageLowIncome() {
		return "renda baixa";
	}


}
