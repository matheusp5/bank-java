package dev.mxtheuz.bank.domain.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateTransactionResponseDto extends UserTransactionDto {
    private UserDto sender;

    public CreateTransactionResponseDto(String id, double amount, UserDto receiver, UserDto sender, LocalDateTime createdAt) {
        super(id, amount, receiver, createdAt);
        this.sender = sender;
    }
}
