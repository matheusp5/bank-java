package dev.mxtheuz.bank.domain.services;

import dev.mxtheuz.bank.domain.dto.CreateUserDto;
import dev.mxtheuz.bank.domain.dto.LoginUserDto;
import dev.mxtheuz.bank.domain.entities.User;

public interface IAuthService {
    boolean login(LoginUserDto model);
    User register(CreateUserDto model);
}
