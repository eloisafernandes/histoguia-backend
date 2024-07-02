package com.histoguia_backend.Histoguia.controller;
import com.histoguia_backend.Histoguia.security.TokenService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.histoguia_backend.Histoguia.model.User;
import com.histoguia_backend.Histoguia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService ts;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        logger.info("Recebido novo usuário: ", user.getLastName());

        User savedUser = userRepository.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid User user ){
        var token = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
        var authetication = manager.authenticate(token);

        return ResponseEntity.ok(ts.createToken((User) authetication.getPrincipal()));
    }

    @CrossOrigin(origins = "http://localhost:3000") // Permitir requisições apenas de http://localhost:3000
    @GetMapping("/test") // Exemplo de configuração para permitir CORS em um endpoint específico
    public String test() {
        return "Test endpoint";
    }
}
