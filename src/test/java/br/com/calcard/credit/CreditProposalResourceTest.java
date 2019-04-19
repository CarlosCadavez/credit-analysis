package br.com.calcard.credit;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.calcard.credit.domain.CreditProposal;
import br.com.calcard.credit.repository.CreditProposals;
import br.com.calcard.credit.resource.CreditProposalResource;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CreditProposalResource.class)
public class CreditProposalResourceTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CreditProposals creditProposals;
	
	private static final String PATH_TO_RESOURCE_TEST = CreditProposalResource.PATH_RESOURCE;
	
	@Test
	public void should_return_status_code_200_when_request_return_a_empty_list_of_credit_proposal() throws Exception {
		mockMvc
		.perform(get(CreditProposalResourceTest.PATH_TO_RESOURCE_TEST))
		.andExpect(status().isOk());
	}
	
	@Test
	public void should_return_status_code_200_when_request_return_a_list_with_two_credit_proposals() throws Exception {
		List<CreditProposal> listOfCreditProposals = new CreditProposeFakeObject().twoCreditProposal();
		
		when(creditProposals.findAll()).thenReturn(listOfCreditProposals);
		
		mockMvc
		.perform(get(CreditProposalResourceTest.PATH_TO_RESOURCE_TEST))
		.andExpect(status().isOk())
		.andExpect(content().json(transformListToJson(listOfCreditProposals)));
	}
	
	@Test
	public void should_return_a_credit_propose_by_cpf_number() throws Exception {
		String fullUriToResource = CreditProposalResourceTest.PATH_TO_RESOURCE_TEST + "/56854401038";
		CreditProposal oneCreditProposal = new CreditProposeFakeObject().oneCreditProposal();
		
		when(creditProposals.findByCpf(Mockito.anyString())).thenReturn(oneCreditProposal);
		
		mockMvc
		.perform(get(fullUriToResource))
		.andExpect(status().isOk())
		.andExpect(content().json(transformObjectToJson(oneCreditProposal)));
	}

	private String transformListToJson(List<CreditProposal> listCreditProposal) throws JsonProcessingException {
		return new ObjectMapper()
				.writer()
				.withDefaultPrettyPrinter()
				.writeValueAsString(listCreditProposal);
	}
	
	private String transformObjectToJson(CreditProposal creditProposal) throws JsonProcessingException {
		return new ObjectMapper()
				.writer()
				.withDefaultPrettyPrinter()
				.writeValueAsString(creditProposal);
	}

}
