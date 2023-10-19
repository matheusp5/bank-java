package dev.mxtheuz.bank.application.services;

import dev.mxtheuz.bank.domain.entities.Transaction;
import dev.mxtheuz.bank.domain.entities.User;
import dev.mxtheuz.bank.domain.repositories.ITransactionRepository;
import dev.mxtheuz.bank.domain.repositories.IUserRepository;
import dev.mxtheuz.bank.domain.services.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService implements ITransactionService {
    @Autowired
    private ITransactionRepository transactionRepository;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Transaction createTransaction(String receiverId, String senderId, double amount) {
        Transaction transaction = Transaction.builder()
                .receiverId(receiverId)
                .senderId(senderId)
                .amount(amount)
                .build();

        User receiver = this.userRepository.findById(receiverId).get();
        User sender = this.userRepository.findById(senderId).get();

        receiver.setBalance(receiver.getBalance() + amount);
        sender.setBalance(sender.getBalance() - amount);

        userRepository.save(receiver);
        userRepository.save(sender);
        return transactionRepository.save(transaction);
    }

    @Override
    public boolean isAvailableToTransaction(String receiverId, String senderId, double amount) {
        Optional<User> receiver = this.userRepository.findById(receiverId);
        Optional<User> sender = this.userRepository.findById(senderId);
        if(receiver.isPresent() && sender.isPresent()) {
            return sender.get().getBalance() >= amount;
        }
        return false;
    }
}
