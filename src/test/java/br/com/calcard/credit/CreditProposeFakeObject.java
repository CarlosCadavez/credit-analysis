package br.com.calcard.credit;

import java.util.Arrays;
import java.util.List;

import br.com.calcard.credit.builder.CreditProposalBuilder;
import br.com.calcard.credit.domain.CreditProposal;
import br.com.calcard.credit.domain.Gender;

public class CreditProposeFakeObject {
	
	public List<CreditProposal> twoCreditProposal() {
		return Arrays.asList(
				CreditProposalBuilder.BUILDER
					.withId(1l)
					.withName("Stephen Lambert")
					.withAge(35)
					.withGender(Gender.FEMALE)
					.build(),
				CreditProposalBuilder.BUILDER
					.withId(2l)
					.withName("Peter Russell")
					.withAge(45)
					.withGender(Gender.MALE)
					.build());
	}
	
	public CreditProposal oneCreditProposal() {
		return CreditProposalBuilder.BUILDER
				.withId(3l)
				.withName("Ava Brown")
				.withAge(31)
				.withGender(Gender.FEMALE) 
				.build();
	}

}
