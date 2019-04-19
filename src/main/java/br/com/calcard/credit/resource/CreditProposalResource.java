package br.com.calcard.credit.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.credit.domain.CreditProposal;

@RestController
@RequestMapping(CreditProposalResource.PATH_RESOURCE)
public class CreditProposalResource {
	
	public static final String PATH_RESOURCE = "/contracts";
	
	@GetMapping
	public ResponseEntity<List<CreditProposal>> allContracts() {
		return ResponseEntity.ok(new ArrayList<>());
	}

}
