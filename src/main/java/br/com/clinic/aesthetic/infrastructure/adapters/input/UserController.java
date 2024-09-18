package br.com.clinic.aesthetic.infrastructure.adapters.input;

import br.com.clinic.aesthetic.application.ports.input.UserUseCase;
import br.com.clinic.aesthetic.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserUseCase userUseCase;

    public UserController(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok(userUseCase.createUser(user));
    }

    @GetMapping
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return userUseCase.findUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
