package dev.mxtheuz.bank.application.services;

import dev.mxtheuz.bank.domain.dto.CreateUserDto;
import dev.mxtheuz.bank.domain.dto.LoginUserDto;
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
    public boolean login(LoginUserDto model) {
        User user = userRepository.findByEmail(model.email());
        if(user == null) return false;
        return hashService.verify(user.getPassword(), model.password());
    }

    @Override
    public User register(CreateUserDto model) {
        User user = User.builder()
                .email(model.email())
                .name(model.name())
                .password(hashService.hash(model.password()))
                .build();


        return userRepository.save(user);
    }
}
