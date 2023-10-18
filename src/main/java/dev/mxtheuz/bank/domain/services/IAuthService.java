package dev.mxtheuz.bank.domain.services;

import dev.mxtheuz.bank.domain.entities.User;

public interface IAuthService {
    boolean login(String email, String password);
    User register(User model);
}
