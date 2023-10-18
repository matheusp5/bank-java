package dev.mxtheuz.bank.application.services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import dev.mxtheuz.bank.domain.services.IHashService;
import org.springframework.stereotype.Service;

@Service
public class HashService implements IHashService {

    @Override
    public String hash(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    @Override
    public boolean verify(String hash, String password) {
        return BCrypt.verifyer().verify(password.toCharArray(), hash).verified;
    }
}
