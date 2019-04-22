package br.com.calcard.credit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.calcard.credit.domain.CreditProposal;
import br.com.calcard.credit.repository.dto.CreditProposalDTO;


public interface CreditProposals extends JpaRepository<CreditProposal, Long> {

	CreditProposal findByCpf(String cpf);
	
	@Query("SELECT new br.com.calcard.credit.repository.dto.CreditProposalDTO(cp.name, cp.age, cp.gender, cp.maritalStatus, cp.state, cp.numberOfDependent, cp.income, cp.statusAnalysis, cp.messageAnalysis) FROM CreditProposal cp ")
	List<CreditProposalDTO> findAllAsDto();
	
}
