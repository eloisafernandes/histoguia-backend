package com.histoguia_backend.Histoguia.controller;
import com.histoguia_backend.Histoguia.model.JwtResponse;
import com.histoguia_backend.Histoguia.model.LoginDTO;
import com.histoguia_backend.Histoguia.model.RegisterDTO;
import com.histoguia_backend.Histoguia.security.TokenService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.histoguia_backend.Histoguia.model.User;
import com.histoguia_backend.Histoguia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


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


    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"User not found\"}");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody @Valid RegisterDTO body) {

        if(userRepository.findByEmail(body.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(body.password());

        logger.info("Recebido novo usuário: ", body.name());

        User newUser = new User(body.name(), body.email(), encryptedPassword, body.role());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDTO body ){

        User optionalUser = (User) userRepository.findByEmail(body.email());

        var token = new UsernamePasswordAuthenticationToken(body.email(), body.password());
        var authentication = manager.authenticate(token);

        //retorno do token
        if(authentication.isAuthenticated()){
            logger.info("Login Realizado: "  + optionalUser.getId() + " " + ts.createToken((User) authentication.getPrincipal()));
            return ResponseEntity.ok(new JwtResponse(ts.createToken((User) authentication.getPrincipal()), optionalUser.getId(), optionalUser.getRole()));
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User updateUserRequest) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(updateUserRequest.getName());
            user.setEmail(updateUserRequest.getEmail());
            user.setBirthDate(updateUserRequest.getBirthDate());
            user.setCourse(updateUserRequest.getCourse());
            user.setPhone(updateUserRequest.getPhone());
            user.setUniversity(updateUserRequest.getUniversity());
            userRepository.save(user);
            logger.info("Usuário Editado com Sucesso");
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"User not found\"}");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            logger.info("Usuário Deletado com Sucesso");
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Student not found\"}");
        }
    }

    @CrossOrigin(origins = "http://localhost:3000") // Permitir requisições apenas de http://localhost:3000
    @GetMapping("/test") // Exemplo de configuração para permitir CORS em um endpoint específico
    public String test() {
        return "Test endpoint";
    }
}
