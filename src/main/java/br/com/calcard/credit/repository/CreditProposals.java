package br.com.calcard.credit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.calcard.credit.domain.CreditProposal;

public interface CreditProposals extends JpaRepository<CreditProposal, Long> {

}
