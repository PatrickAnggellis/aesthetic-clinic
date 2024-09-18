package br.com.clinic.aesthetic.application.ports.output;

import br.com.clinic.aesthetic.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);

    User save(User user);

    void deleteById(Long id);

}
