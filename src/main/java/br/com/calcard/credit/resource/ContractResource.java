package br.com.calcard.credit.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ContractResource.PATH_RESOURCE)
public class ContractResource {
	
	public static final String PATH_RESOURCE = "/contracts";
	
	@GetMapping
	public ResponseEntity<List<String>> allContracts() {
		return ResponseEntity.ok(new ArrayList<>());
	}

}
