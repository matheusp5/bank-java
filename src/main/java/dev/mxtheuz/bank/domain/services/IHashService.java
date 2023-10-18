package dev.mxtheuz.bank.domain.services;

public interface IHashService {
    String hash(String password);
    boolean verify(String hash, String password);
}
