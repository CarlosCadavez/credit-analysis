package br.com.calcard.credit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcard.credit.analysis.CreditAnalysis;
import br.com.calcard.credit.domain.CreditProposal;
import br.com.calcard.credit.domain.StatusAnalysis;
import br.com.calcard.credit.repository.CreditProposals;
import br.com.calcard.credit.service.exception.CreditProposeNotFoundedException;

@Service
public class CreditProposalService {
	
	@Autowired
	private CreditProposals creditProposals;
	
	public CreditProposal findByCpf(String cpf) {
		
		CreditProposal creditProposal = creditProposals.findByCpf(cpf);
		
		if (creditProposal == null) {
			String message = String.format("Credit propose not founded for cpf: %s", cpf);
			throw new CreditProposeNotFoundedException(message);
		}
		
		return creditProposal;
	}

	public CreditProposal addCreditProposal(CreditProposal creditProposal) {
		CreditAnalysis creditAnalysis = runCreditAnalysis(creditProposal);
		
		if (creditAnalysis.creditIsAproved()) {
			creditProposal.setStatusAnalysis(StatusAnalysis.APROVED);
		}
		else {
			creditProposal.setStatusAnalysis(StatusAnalysis.DISAPROVED);
		}
		creditProposal.setMessageAnalysis(creditAnalysis.getMessageLimitFeedback());
		
		return creditProposals.save(creditProposal);
	}

	private CreditAnalysis runCreditAnalysis(CreditProposal creditProposal) {
		CreditAnalysis creditAnalysis = new CreditAnalysis();
		creditAnalysis.runAnalysis(creditProposal);
		return creditAnalysis;
		
	}

}
