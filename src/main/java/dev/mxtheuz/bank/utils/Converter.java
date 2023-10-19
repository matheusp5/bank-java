package dev.mxtheuz.bank.utils;

import dev.mxtheuz.bank.domain.dto.CreateTransactionResponseDto;
import dev.mxtheuz.bank.domain.dto.UserDto;
import dev.mxtheuz.bank.domain.dto.UserTransactionDto;
import dev.mxtheuz.bank.domain.entities.Transaction;
import dev.mxtheuz.bank.domain.entities.User;
import dev.mxtheuz.bank.domain.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Converter {

    @Autowired
    private IUserRepository userRepository;

    public UserDto convertUserToUserDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    public CreateTransactionResponseDto convertTransactionToTransactionResponseDto(Transaction transaction) {
        return new CreateTransactionResponseDto(
                transaction.getId(),
                transaction.getAmount(),
                this.convertUserToUserDto(userRepository.findById(transaction.getReceiverId()).get()),
                this.convertUserToUserDto(userRepository.findById(transaction.getSenderId()).get()),
                        transaction.getCreatedAt()
                        );
    }

    public UserTransactionDto convertTransactionToUserTransactionResponseDto(Transaction transaction) {
        return new UserTransactionDto(
                transaction.getId(),
                transaction.getAmount(),
                this.convertUserToUserDto(userRepository.findById(transaction.getReceiverId()).get()),
                transaction.getCreatedAt()
        );
    }
}
