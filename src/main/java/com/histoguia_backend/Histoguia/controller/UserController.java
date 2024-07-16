package com.histoguia_backend.Histoguia.controller;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        var token = new UsernamePasswordAuthenticationToken(body.email(), body.password());
        var authentication = manager.authenticate(token);

        //retorno do token
        if(authentication.isAuthenticated()){
            logger.info("Login Realizado: " + body.email() + body.password());
            return ResponseEntity.ok(ts.createToken((User) authentication.getPrincipal()));
        }

        return ResponseEntity.badRequest().build();
    }

    @CrossOrigin(origins = "http://localhost:3000") // Permitir requisições apenas de http://localhost:3000
    @GetMapping("/test") // Exemplo de configuração para permitir CORS em um endpoint específico
    public String test() {
        return "Test endpoint";
    }
}
