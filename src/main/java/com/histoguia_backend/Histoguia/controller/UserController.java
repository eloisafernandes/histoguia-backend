package com.histoguia_backend.Histoguia.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.histoguia_backend.Histoguia.model.User;
import com.histoguia_backend.Histoguia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        logger.info("Recebido novo usuário: ", user.getLastName());

        User savedUser = userRepository.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:3000") // Permitir requisições apenas de http://localhost:3000
    @GetMapping("/test") // Exemplo de configuração para permitir CORS em um endpoint específico
    public String test() {
        return "Test endpoint";
    }
}
