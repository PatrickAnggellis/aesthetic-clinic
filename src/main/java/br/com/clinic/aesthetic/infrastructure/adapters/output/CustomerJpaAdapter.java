package br.com.clinic.aesthetic.infrastructure.adapters.output;

import br.com.clinic.aesthetic.application.ports.output.CustomerRepository;
import br.com.clinic.aesthetic.domain.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class CustomerJpaAdapter implements CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll(){
        return entityManager.createQuery("SELECT p FROM Customer c", Customer.class).getResultList();
    }

    @Override
    public Optional<Customer> findById(Long id){
        return Optional.ofNullable(entityManager.find(Customer.class, id));
    }

    @Override
    public Customer save(Customer customer) {
        if(customer.getId() == null){
            entityManager.persist(customer);
        } else {
            customer = entityManager.merge(customer);
        }
        return customer;
    }

    @Override
    public void deleteById(Long id){
        Customer customer = entityManager.find(Customer.class, id);
        if(customer != null) {
            entityManager.remove(customer);
        }
    }


}
