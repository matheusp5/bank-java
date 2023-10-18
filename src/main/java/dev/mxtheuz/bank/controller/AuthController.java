package dev.mxtheuz.bank.controller;

import dev.mxtheuz.bank.application.services.AuthService;
import dev.mxtheuz.bank.application.services.JwtService;
import dev.mxtheuz.bank.domain.dto.HttpResponse;
import dev.mxtheuz.bank.domain.entities.User;
import dev.mxtheuz.bank.domain.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtService jwtService;


    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<HttpResponse> Login(@RequestBody User dto) {
        if(authService.login(dto.getEmail(), dto.getPassword())) {
            User user = userRepository.findByEmail(dto.getEmail());
            String token = jwtService.createToken(user.getId());
            return ResponseEntity.ok(new HttpResponse(200, "authorized", token));
        }

        return ResponseEntity.ok(new HttpResponse(401, "unauthorized", ""));
    }

    @PostMapping("/register")
    public ResponseEntity<HttpResponse> Register(@RequestBody User dto) {
        if(userRepository.findByEmail(dto.getEmail()) == null) {
            User user = authService.register(dto);
            return ResponseEntity.status(201).body(new HttpResponse(201, "created", user));
        }

        return ResponseEntity.status(400).body(new HttpResponse(400, "email_already_exists", ""));
    }
}
