package dev.mxtheuz.bank.controller;

import dev.mxtheuz.bank.application.services.AuthService;
import dev.mxtheuz.bank.domain.dto.HttpResponse;
import dev.mxtheuz.bank.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    public ResponseEntity<HttpResponse> Login(@RequestBody User dto) {

    }

    public ResponseEntity<HttpResponse> Register(@RequestBody User dto) {

    }
}
