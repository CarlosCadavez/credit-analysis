package br.com.calcard.credit.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.credit.domain.CreditProposal;
import br.com.calcard.credit.repository.CreditProposals;

@RestController
@RequestMapping(CreditProposalResource.PATH_RESOURCE)
public class CreditProposalResource {
	
	public static final String PATH_RESOURCE = "/credit-proposals";
	
	@Autowired
	private CreditProposals creditProposals;
	
	@GetMapping
	public ResponseEntity<List<CreditProposal>> allCreditProposal() {
		return ResponseEntity.ok(creditProposals.findAll());
	}

}
