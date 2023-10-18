package dev.mxtheuz.bank.application.services;

import dev.mxtheuz.bank.domain.entities.User;
import dev.mxtheuz.bank.domain.repositories.IUserRepository;
import dev.mxtheuz.bank.domain.services.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public boolean login(String email, String password) {
        return false;
    }

    @Override
    public User register(User model) {
        return null;
    }
}
