package br.com.calcard.credit.analysis;

import static org.hamcrest.CoreMatchers.equalTo;

import java.math.BigDecimal;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import br.com.calcard.credit.builder.DataAnalysisBuilder;
import br.com.calcard.credit.domain.MaritalStatus;

public class CreditAnalysisTest {
	
	@Rule
	public ErrorCollector assertCollector = new ErrorCollector();
	
	@Test
	public void should_aprove_a_propose_with_boundary_beetwen_20_and_40_percent_of_user_income() {
		String expectedMessageReturn = "entre 500 - 1000";
		DataAnalysisBuilder dataToAnalyse = new DataAnalysisBuilder()
				.withUserAge(28)
				.withUserMaritalStatus(MaritalStatus.SINGLE)
				.withUserNumberDependents(0)
				.withUserIncome(new BigDecimal("2500"));
		
		CreditAnalysis creditAnalysis = new CreditAnalysis();
		creditAnalysis.runAnalysis(dataToAnalyse.build());
		
		assertCollector.checkThat(true, equalTo(creditAnalysis.creditIsAproved()));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitInit(), equalTo(Double.valueOf(500)));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitFinal(), equalTo(Double.valueOf(1000)));
		assertCollector.checkThat(creditAnalysis.getMessageLimitFeedback(), equalTo(expectedMessageReturn));
		
	}
	
	@Test
	public void should_aprove_a_propose_with_boundary_beetwen_100_and_500_for_a_woman_with_age_equal_to_17_without_dependent() {
		String expectedMessageReturn = "entre 100 - 500";
		DataAnalysisBuilder dataToAnalyse = new DataAnalysisBuilder()
				.withUserAge(17)
				.withUserMaritalStatus(MaritalStatus.SINGLE)
				.withUserNumberDependents(0)
				.withUserIncome(new BigDecimal("1000"));
		
		CreditAnalysis creditAnalysis = new CreditAnalysis();
		creditAnalysis.runAnalysis(dataToAnalyse.build());
		
		assertCollector.checkThat(true, equalTo(creditAnalysis.creditIsAproved()));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitInit(), equalTo(Double.valueOf(100)));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitFinal(), equalTo(Double.valueOf(500)));
		assertCollector.checkThat(creditAnalysis.getMessageLimitFeedback(), equalTo(expectedMessageReturn));
		
	}
	
	@Test
	public void should_aprove_a_propose_with_boundary_beetwen_1500_and_2000_for_a_man_with_age_equal_to_68_with_3_dependent() {
		String expectedMessageReturn = "entre 1500 - 2000";
		DataAnalysisBuilder dataToAnalyse = new DataAnalysisBuilder()
				.withUserAge(17)
				.withUserMaritalStatus(MaritalStatus.MARRIED)
				.withUserNumberDependents(3)
				.withUserIncome(new BigDecimal("8000"));
		
		CreditAnalysis creditAnalysis = new CreditAnalysis();
		creditAnalysis.runAnalysis(dataToAnalyse.build());
		
		assertCollector.checkThat(true, equalTo(creditAnalysis.creditIsAproved()));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitInit(), equalTo(Double.valueOf(1500)));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitFinal(), equalTo(Double.valueOf(2000)));
		assertCollector.checkThat(creditAnalysis.getMessageLimitFeedback(), equalTo(expectedMessageReturn));
		
	}
	
	@Test
	public void should_aprove_a_propose_with_boundary_beetwen_1000_and_1500_for_a_woman_with_age_equal_to_61_with_3_dependent() {
		String expectedMessageReturn = "entre 1000 - 1500";
		DataAnalysisBuilder dataToAnalyse = new DataAnalysisBuilder()
				.withUserAge(61)
				.withUserMaritalStatus(MaritalStatus.MARRIED)
				.withUserNumberDependents(3)
				.withUserIncome(new BigDecimal("5000"));
		
		CreditAnalysis creditAnalysis = new CreditAnalysis();
		creditAnalysis.runAnalysis(dataToAnalyse.build());
		
		assertCollector.checkThat(true, equalTo(creditAnalysis.creditIsAproved()));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitInit(), equalTo(Double.valueOf(1000)));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitFinal(), equalTo(Double.valueOf(1500)));
		assertCollector.checkThat(creditAnalysis.getMessageLimitFeedback(), equalTo(expectedMessageReturn));
		
	}
	
	@Test
	public void should_disaprove_a_propose_for_a_man_divorced_with_age_equal_to_56_with_2_dependent() {
		String expectedMessageReturn = "reprovado pela política de crédito";
		DataAnalysisBuilder dataToAnalyse = new DataAnalysisBuilder()
				.withUserAge(56)
				.withUserMaritalStatus(MaritalStatus.DIVORCED)
				.withUserNumberDependents(2)
				.withUserIncome(new BigDecimal("2000"));
		
		CreditAnalysis creditAnalysis = new CreditAnalysis();
		creditAnalysis.runAnalysis(dataToAnalyse.build());
		
		assertCollector.checkThat(false, equalTo(creditAnalysis.creditIsAproved()));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitInit(), equalTo(Double.valueOf(0)));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitFinal(), equalTo(Double.valueOf(0)));
		assertCollector.checkThat(creditAnalysis.getMessageLimitFeedback(), equalTo(expectedMessageReturn));
		
	}
	
	@Test
	public void should_disaprove_a_propose_for_a_woman_divorced_with_age_equal_to_45_with_1_dependent() {
		String expectedMessageReturn = "reprovado pela política de crédito";
		DataAnalysisBuilder dataToAnalyse = new DataAnalysisBuilder()
				.withUserAge(45)
				.withUserMaritalStatus(MaritalStatus.DIVORCED)
				.withUserNumberDependents(1)
				.withUserIncome(new BigDecimal("2000"));
		
		CreditAnalysis creditAnalysis = new CreditAnalysis();
		creditAnalysis.runAnalysis(dataToAnalyse.build());
		
		assertCollector.checkThat(false, equalTo(creditAnalysis.creditIsAproved()));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitInit(), equalTo(Double.valueOf(0)));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitFinal(), equalTo(Double.valueOf(0)));
		assertCollector.checkThat(creditAnalysis.getMessageLimitFeedback(), equalTo(expectedMessageReturn));
		
	}
	
	@Test
	public void should_aprove_a_propose_with_limit_greathen_than_2000_for_a_man_with_age_equal_to_30_with_2_dependent_and_income_equal_to_8000() {
		String expectedMessageReturn = "superior 2000";
		DataAnalysisBuilder dataToAnalyse = new DataAnalysisBuilder()
				.withUserAge(61)
				.withUserMaritalStatus(MaritalStatus.MARRIED)
				.withUserNumberDependents(2)
				.withUserIncome(new BigDecimal("8000"));
		
		CreditAnalysis creditAnalysis = new CreditAnalysis();
		creditAnalysis.runAnalysis(dataToAnalyse.build());
		
		assertCollector.checkThat(true, equalTo(creditAnalysis.creditIsAproved()));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitInit(), equalTo(Double.valueOf(2000)));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitFinal(), equalTo(Double.valueOf(2000)));
		assertCollector.checkThat(creditAnalysis.getMessageLimitFeedback(), equalTo(expectedMessageReturn));
		
	}
	
	@Test
	public void should_aprove_a_propose_with_limit_greathen_than_2000_for_a_man_with_age_equal_to_33_with_1_dependent_and_income_equal_to_10000() {
		String expectedMessageReturn = "superior 2000";
		DataAnalysisBuilder dataToAnalyse = new DataAnalysisBuilder()
				.withUserAge(33)
				.withUserMaritalStatus(MaritalStatus.MARRIED)
				.withUserNumberDependents(2)
				.withUserIncome(new BigDecimal("10000"));
		
		CreditAnalysis creditAnalysis = new CreditAnalysis();
		creditAnalysis.runAnalysis(dataToAnalyse.build());
		
		assertCollector.checkThat(true, equalTo(creditAnalysis.creditIsAproved()));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitInit(), equalTo(Double.valueOf(2000)));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitFinal(), equalTo(Double.valueOf(2000)));
		assertCollector.checkThat(creditAnalysis.getMessageLimitFeedback(), equalTo(expectedMessageReturn));
		
	}
	
	@Test
	public void should_disaprove_a_propose_for_a_man_with_age_equal_to_19_with_1_dependent_and_income_equal_to_400() {
		String expectedMessageReturn = "renda baixa";
		DataAnalysisBuilder dataToAnalyse = new DataAnalysisBuilder()
				.withUserAge(19)
				.withUserMaritalStatus(MaritalStatus.SINGLE)
				.withUserNumberDependents(1)
				.withUserIncome(new BigDecimal("400"));
		
		CreditAnalysis creditAnalysis = new CreditAnalysis();
		creditAnalysis.runAnalysis(dataToAnalyse.build());
		
		assertCollector.checkThat(false, equalTo(creditAnalysis.creditIsAproved()));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitInit(), equalTo(Double.valueOf(0)));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitFinal(), equalTo(Double.valueOf(0)));
		assertCollector.checkThat(creditAnalysis.getMessageLimitFeedback(), equalTo(expectedMessageReturn));
		
	}
	
	@Test
	public void should_disaprove_a_propose_for_a_woman_with_age_equal_to_63_with_3_dependent_income_equal_to_1500() {
		String expectedMessageReturn = "reprovado pela política de crédito";
		DataAnalysisBuilder dataToAnalyse = new DataAnalysisBuilder()
				.withUserAge(63)
				.withUserMaritalStatus(MaritalStatus.WIDOWED)
				.withUserNumberDependents(3)
				.withUserIncome(new BigDecimal("1500"));
		
		CreditAnalysis creditAnalysis = new CreditAnalysis();
		creditAnalysis.runAnalysis(dataToAnalyse.build());
		
		assertCollector.checkThat(false, equalTo(creditAnalysis.creditIsAproved()));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitInit(), equalTo(Double.valueOf(0)));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitFinal(), equalTo(Double.valueOf(0)));
		assertCollector.checkThat(creditAnalysis.getMessageLimitFeedback(), equalTo(expectedMessageReturn));
		
	}
	
	@Test
	public void should_aprove_a_propose_for_a_woman_with_age_equal_to_28_with_2_dependent_income_equal_to_2500() {
		String expectedMessageReturn = "entre 100 - 500";
		DataAnalysisBuilder dataToAnalyse = new DataAnalysisBuilder()
				.withUserAge(28)
				.withUserMaritalStatus(MaritalStatus.SINGLE)
				.withUserNumberDependents(2)
				.withUserIncome(new BigDecimal("2500"));
		
		CreditAnalysis creditAnalysis = new CreditAnalysis();
		creditAnalysis.runAnalysis(dataToAnalyse.build());
		
		assertCollector.checkThat(true, equalTo(creditAnalysis.creditIsAproved()));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitInit(), equalTo(Double.valueOf(100)));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitFinal(), equalTo(Double.valueOf(500)));
		assertCollector.checkThat(creditAnalysis.getMessageLimitFeedback(), equalTo(expectedMessageReturn));
		
	}
	
	@Test
	public void should_disaprove_a_propose_for_a_man_with_age_equal_to_16_and_income_equal_to_500() {
		String expectedMessageReturn = "renda baixa";
		DataAnalysisBuilder dataToAnalyse = new DataAnalysisBuilder()
				.withUserAge(16)
				.withUserMaritalStatus(MaritalStatus.SINGLE)
				.withUserNumberDependents(1)
				.withUserIncome(new BigDecimal("500"));
		
		CreditAnalysis creditAnalysis = new CreditAnalysis();
		creditAnalysis.runAnalysis(dataToAnalyse.build());
		
		assertCollector.checkThat(false, equalTo(creditAnalysis.creditIsAproved()));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitInit(), equalTo(Double.valueOf(0)));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitFinal(), equalTo(Double.valueOf(0)));
		assertCollector.checkThat(expectedMessageReturn, equalTo(creditAnalysis.getMessageLimitFeedback()));
		
	}
	
	@Test
	public void should_aprove_a_propose_with_boundary_beetwen_1000_and_1500_for_a_man_with_age_equal_to_30_with_5_dependent() {
		String expectedMessageReturn = "entre 1000 - 1500";
		DataAnalysisBuilder dataToAnalyse = new DataAnalysisBuilder()
				.withUserAge(30)
				.withUserMaritalStatus(MaritalStatus.MARRIED)
				.withUserNumberDependents(5)
				.withUserIncome(new BigDecimal("8000"));
		
		CreditAnalysis creditAnalysis = new CreditAnalysis();
		creditAnalysis.runAnalysis(dataToAnalyse.build());
		
		assertCollector.checkThat(true, equalTo(creditAnalysis.creditIsAproved()));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitInit(), equalTo(Double.valueOf(1000)));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitFinal(), equalTo(Double.valueOf(1500)));
		assertCollector.checkThat(creditAnalysis.getMessageLimitFeedback(), equalTo(expectedMessageReturn));
		
	}
	
	@Test
	public void should_aprove_a_propose_with_limit_greathen_than_2000_for_a_woman_with_age_equal_to_33and_income_equal_to_10000() {
		String expectedMessageReturn = "superior 2000";
		DataAnalysisBuilder dataToAnalyse = new DataAnalysisBuilder()
				.withUserAge(33)
				.withUserMaritalStatus(MaritalStatus.WIDOWED)
				.withUserNumberDependents(2)
				.withUserIncome(new BigDecimal("10000"));
		
		CreditAnalysis creditAnalysis = new CreditAnalysis();
		creditAnalysis.runAnalysis(dataToAnalyse.build());
		
		assertCollector.checkThat(true, equalTo(creditAnalysis.creditIsAproved()));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitInit(), equalTo(Double.valueOf(2000)));
		assertCollector.checkThat(creditAnalysis.getCreditStrip().getLimitFinal(), equalTo(Double.valueOf(2000)));
		assertCollector.checkThat(creditAnalysis.getMessageLimitFeedback(), equalTo(expectedMessageReturn));
		
	}
	
	

}
