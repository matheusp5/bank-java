package dev.mxtheuz.bank.controller;

import dev.mxtheuz.bank.domain.dto.GetUserResponse;
import dev.mxtheuz.bank.domain.dto.HttpResponse;
import dev.mxtheuz.bank.domain.dto.UserDto;
import dev.mxtheuz.bank.domain.dto.UserTransactionDto;
import dev.mxtheuz.bank.domain.entities.Transaction;
import dev.mxtheuz.bank.domain.repositories.ITransactionRepository;
import dev.mxtheuz.bank.domain.repositories.IUserRepository;
import dev.mxtheuz.bank.utils.Converter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final IUserRepository userRepository;

    private final Converter converter;

    private final ITransactionRepository transactionRepository;

    @Autowired
    public UserController(IUserRepository userRepository, Converter converter, ITransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.converter = converter;
        this.transactionRepository = transactionRepository;
    }

    @GetMapping
    public ResponseEntity<HttpResponse> GetUser(HttpServletRequest request) {
        String userId = (String) request.getAttribute("userId");
        UserDto user = this.converter.convertUserToUserDto(userRepository.findById(userId).get());
        List<Transaction> transactions = transactionRepository.findBySenderId(userId);
        List<UserTransactionDto> transactionsDto = transactions.stream().map(converter::convertTransactionToUserTransactionResponseDto).toList();
        return ResponseEntity.ok(new HttpResponse(200, "success", new GetUserResponse(user, transactionsDto)));
    }
}
