package br.com.calcard.credit.analysis;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.calcard.credit.domain.MaritalStatus;

public class CreditAnalysisTest {
	
	@Test
	public void should_aprove_a_propose_with_boundary_beetwen_20_and_40_percent_of_user_income() {
		Integer clientAge = 28;
		Integer numberOfDependents = 0;
		BigDecimal userIncome = new BigDecimal("2500");
		Credible creditAnalysis = new CreditAnalysis(clientAge, MaritalStatus.SINGLE, numberOfDependents, userIncome);
		
		assertThat(true, equalTo(creditAnalysis.creditAproved()));
	}

}
