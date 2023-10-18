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

    @Autowired
    private HashService hashService;

    @Override
    public boolean login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if(user == null) return false;
        return hashService.verify(password, user.getPassword());
    }

    @Override
    public User register(User model) {
        model.setPassword(hashService.hash(model.getPassword()));
        return userRepository.save(model);
    }
}
