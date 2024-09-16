package br.com.clinic.aesthetic.application.ports.input;

import java.util.List;
import java.util.Optional;

import br.com.clinic.aesthetic.domain.Customer;

public interface CustomerUseCase {

    List<Customer> listCustomers();
    Optional<Customer> findCustomer(Long id);
    Customer createCustomer(Customer customer);
    Optional<Customer> updateCustomer(Long id, Customer CustomerUpdated);
    boolean deleteCustomer(Long id);
    
}
