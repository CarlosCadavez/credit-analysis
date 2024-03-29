package br.com.calcard.credit.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.calcard.credit.domain.CreditProposal;
import br.com.calcard.credit.repository.CreditProposals;
import br.com.calcard.credit.repository.dto.CreditProposalDTO;
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
	@CrossOrigin
	public ResponseEntity<List<CreditProposalDTO>> allCreditProposal() {
		return ResponseEntity.ok(creditProposals.findAllAsDto());
	}
	
	@GetMapping(value = "/{cpf}")
	public ResponseEntity<CreditProposal> creditProposalByCpfNumber(@PathVariable("cpf") String cpf) {
		return ResponseEntity.ok(creditProposalService.findByCpf(cpf));
	}
	
	@PostMapping
	@CrossOrigin
	public ResponseEntity<List<CreditProposal>> addCreditPropose(@Valid @RequestBody CreditProposal creditPropose) throws URISyntaxException {
		CreditProposal creditProposal = creditProposalService.addCreditProposal(creditPropose);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(creditProposal.getId())
				.toUri();
		
		return ResponseEntity.created(uri).build();
	}

}
