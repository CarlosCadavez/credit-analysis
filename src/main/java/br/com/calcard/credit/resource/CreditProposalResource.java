package br.com.calcard.credit.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.credit.domain.CreditProposal;
import br.com.calcard.credit.repository.CreditProposals;
import br.com.calcard.credit.service.CreditProposalService;

@RestController
@RequestMapping(CreditProposalResource.PATH_RESOURCE)
public class CreditProposalResource {
	
	public static final String PATH_RESOURCE = "/credit-proposals";
	
	@Autowired
	private CreditProposals creditProposals;
	
	@Autowired
	private CreditProposalService creditProposalService;
	
	@GetMapping
	public ResponseEntity<List<CreditProposal>> allCreditProposal() {
		return ResponseEntity.ok(creditProposals.findAll());
	}
	
	@GetMapping(value = "/{cpf}")
	public ResponseEntity<CreditProposal> creditProposalByCpfNumber(@PathVariable("cpf") String cpf) {
		return ResponseEntity.ok(creditProposalService.findByCpf(cpf));
	}
	
	@PostMapping
	public ResponseEntity<List<CreditProposal>> addCreditPropose() throws URISyntaxException {
		return ResponseEntity.created(new URI("")).build();
	}

}
