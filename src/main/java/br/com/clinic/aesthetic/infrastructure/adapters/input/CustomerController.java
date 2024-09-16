package br.com.clinic.aesthetic.infrastructure.adapters.input;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clinic.aesthetic.application.ports.input.CustomerUseCase;
import br.com.clinic.aesthetic.domain.Customer;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerUseCase customerUseCase;

    public CustomerController (CustomerUseCase customerUseCase){
        this.customerUseCase = customerUseCase;
    };

    @GetMapping
    public List<Customer> listCustomers(){
        return customerUseCase.listCustomers();
    }

    @GetMapping("/id")
    public ResponseEntity<Customer> findCustomer(@PathVariable Long id) {
        return customerUseCase.findCustomer(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerUseCase.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerUpdated) {
         return customerUseCase.updateCustomer(id, customerUpdated)
         .map(ResponseEntity::ok)
         .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteCustomer(@RequestBody Long id) {
        if(customerUseCase.deleteCustomer(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    
    
    
    
    
}
