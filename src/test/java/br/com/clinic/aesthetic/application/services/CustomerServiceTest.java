package br.com.clinic.aesthetic.application.services;

import br.com.clinic.aesthetic.application.ports.output.AddressApiPort;
import br.com.clinic.aesthetic.application.ports.output.CustomerRepository;
import br.com.clinic.aesthetic.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private AddressApiPort addressApiPort;

    private CustomerService customerService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        customerService = new CustomerService(customerRepository);
    }

    @Test
    void getCustomerById_shouldReturnCustomer_whenCustomerExists(){
        Long id = 1L;
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("Paulo");

        when(customerRepository.findById(id)).thenReturn(Optional.of(customer));

        Optional<Customer> result = customerService.findCustomer(id);

        assertNotNull(result);
        assertEquals(id, result.get().getId());
        assertEquals("Paulo", result.get().getName());

    }

//    @Test
//    void getCustomerById_shouldThrowException_whenCustomerNotFound(){
//        Long id = 1L;
//        when(customerRepository.findById(id)).thenReturn(Optional.empty());
//
//        assertThrows(RuntimeException.class, ()-> customerService.findCustomer(id));
//    }

}