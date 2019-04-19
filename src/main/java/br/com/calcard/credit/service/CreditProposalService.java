package br.com.calcard.credit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcard.credit.domain.CreditProposal;
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

}
