package br.com.clinic.aesthetic.application.ports.output;

import java.util.List;
import java.util.Optional;

import br.com.clinic.aesthetic.domain.Customer;

public interface CustomerRepository {
    
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    Customer save(Customer customer);
    void deleteById(Long id);
}
