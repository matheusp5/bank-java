package dev.mxtheuz.bank.controller;

import dev.mxtheuz.bank.application.services.TransactionService;
import dev.mxtheuz.bank.domain.dto.CreateTransactionDto;
import dev.mxtheuz.bank.domain.dto.HttpResponse;
import dev.mxtheuz.bank.domain.repositories.ITransactionRepository;
import dev.mxtheuz.bank.utils.Converter;
import jakarta.persistence.Convert;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/transaction")
public class TransactionController {

    @Autowired
    private ITransactionRepository transactionRepository;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private Converter converter;

    @PostMapping
    public ResponseEntity<HttpResponse> CreateTransaction(@RequestBody CreateTransactionDto dto, HttpServletRequest request) {
        String senderId = (String) request.getAttribute("userId");
        if(this.transactionService.isAvailableToTransaction(dto.receiverId(), senderId, dto.amount())) {
            return ResponseEntity.status(201).body(new HttpResponse(201, "success", this.converter.convertTransactionToTransactionResponseDto(transactionService.createTransaction(dto.receiverId(), senderId, dto.amount()))));
        }
        return ResponseEntity.status(400).body(HttpResponse.builder()
                        .code(400)
                        .message("unavailable")
                .build());
    }

    @GetMapping
    public ResponseEntity<HttpResponse> GetTransactions(HttpServletRequest request) {
        String senderId = (String) request.getAttribute("userId");
        return ResponseEntity.ok(new HttpResponse(200, "success", transactionRepository.findBySenderId(senderId)));
    }

}
