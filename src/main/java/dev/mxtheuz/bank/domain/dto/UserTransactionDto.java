package dev.mxtheuz.bank.domain.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@NoArgsConstructor
@ToString
public class UserTransactionDto {
    private String id;
    private double amount;
    private UserDto receiver;
    @CreatedDate
    @CreationTimestamp
    private LocalDateTime createdAt;

    public UserTransactionDto(String id, double amount, UserDto receiver, LocalDateTime createdAt) {
        this.id = id;
        this.amount = amount;
        this.receiver = receiver;
        this.createdAt = createdAt;
    }
}
