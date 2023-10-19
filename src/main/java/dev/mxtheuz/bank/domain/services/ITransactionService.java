package dev.mxtheuz.bank.domain.services;

import dev.mxtheuz.bank.domain.entities.Transaction;

public interface ITransactionService {
    Transaction createTransaction(String receiverId, String senderId, double amount);
    boolean isAvailableToTransaction(String receiverId, String senderId, double amount);
}
