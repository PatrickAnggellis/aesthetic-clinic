package br.com.clinic.aesthetic.application.services;

import br.com.clinic.aesthetic.application.ports.input.CustomerUseCase;
import br.com.clinic.aesthetic.domain.Customer;
import br.com.clinic.aesthetic.infrastructure.adapters.input.CustomerController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerIntegrationTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private CustomerUseCase customerUseCase;
//
//    @Test
//    void createCustomer_shouldRturnCreated() throws Exception {
//        Customer customer = new Customer();
//        customer.setName("Paulo");
//        customer.setCpf("12345678901");
//
//        when(customerUseCase.createCustomer(any(Customer.class))).thenReturn(customer);
//
//        mockMvc.perform(post("api/customers")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\name\": \"Paulo\", \"cpf\":\"12345678901\"}"))
//                .andExpect(status().isCreated());
//    }

}
