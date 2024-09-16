package br.com.clinic.aesthetic.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.clinic.aesthetic.application.ports.input.CustomerUseCase;
import br.com.clinic.aesthetic.application.ports.output.CustomerRepository;
import br.com.clinic.aesthetic.domain.Customer;

@Service
public class CustomerService implements CustomerUseCase {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> listCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findCustomer(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer createCustomer(Customer customer) {
       return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> updateCustomer(Long id, Customer customerUpdated) {
       return customerRepository.findById(id)
        .map(customerExisting -> {
            customerUpdated.setId(customerExisting.getId());
            return customerRepository.save(customerUpdated);
       });
    }

    @Override
    public boolean deleteCustomer(Long id) {
        if (customerRepository.findById(id).isPresent()) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
}
