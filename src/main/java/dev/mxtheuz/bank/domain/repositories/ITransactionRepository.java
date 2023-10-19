package dev.mxtheuz.bank.domain.repositories;

import dev.mxtheuz.bank.domain.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITransactionRepository extends JpaRepository<Transaction, String> {
    List<Transaction> findByReceiverId(String id);
    List<Transaction> findBySenderId(String id);
}
