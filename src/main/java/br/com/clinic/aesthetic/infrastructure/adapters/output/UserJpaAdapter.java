package br.com.clinic.aesthetic.infrastructure.adapters.output;

import br.com.clinic.aesthetic.application.ports.output.UserRepository;
import br.com.clinic.aesthetic.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Transactional
@Component
public class UserJpaAdapter implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Optional<User> findByEmail(String email) {
        try{
            TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
            query.setParameter("email", email);
            return Optional.ofNullable(query.getSingleResult());
        } catch(NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public User save(User user) {

        if(user.getId() == null || user.getEmail() == null){
            entityManager.persist(user);
        } else {
            user = entityManager.merge(user);
        }
        return user;
    }

    @Override
    public void deleteById(Long id) {
        User user = entityManager.find(User.class, id);
        if(user != null){
            entityManager.remove(user);
        }
    }
}
