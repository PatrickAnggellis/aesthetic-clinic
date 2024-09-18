package br.com.clinic.aesthetic.application.ports.input;

import br.com.clinic.aesthetic.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserUseCase {

    Optional<User> findUserById(Long id);
    User createUser(User user);
    Optional<User> findUserByEmail(String email);
    boolean deleteUser(Long id);
}
