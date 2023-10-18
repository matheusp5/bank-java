package dev.mxtheuz.bank.domain.services;

public interface IJwtService {
    String createToken(String id);
    String decodeToken(String token);
}
