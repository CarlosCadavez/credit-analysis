package br.com.calcard.credit.builder;

import br.com.calcard.credit.domain.CreditProposal;
import br.com.calcard.credit.domain.Gender;

public class CreditProposalBuilder {
	
	public static final CreditProposalBuilder BUILDER = new CreditProposalBuilder();
	
	private CreditProposal creditProposal;
	
	private CreditProposalBuilder() {
		this.creditProposal = new CreditProposal();
	}

	public CreditProposal build() {
		return this.creditProposal;
	}

	public CreditProposalBuilder withId(Long id) {
		creditProposal.setId(id);
		return this;
	}

	public CreditProposalBuilder withName(String name) {
		creditProposal.setName(name);
		return this;
	}

	public CreditProposalBuilder withAge(int age) {
		creditProposal.setAge(age);
		return this;
	}

	public CreditProposalBuilder withGender(Gender gender) {
		creditProposal.setGender(gender);
		return this;
	}

}
