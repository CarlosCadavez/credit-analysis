package br.com.calcard.credit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.calcard.credit.resource.ContractResource;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ContractResource.class)
public class ContractResourceTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	private static final String PATH_TO_RESOURCE_TEST = ContractResource.PATH_RESOURCE;
	
	@Test
	public void should_return_status_code_200_when_request_return_a_empty_list_of_contract() throws Exception {
		mockMvc
		.perform(get(ContractResourceTest.PATH_TO_RESOURCE_TEST))
		.andExpect(status().isOk());
	}

}