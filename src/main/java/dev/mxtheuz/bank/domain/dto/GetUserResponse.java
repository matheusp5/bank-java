package dev.mxtheuz.bank.domain.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetUserResponse extends UserDto {
    private List<UserTransactionDto> transactions;
    private double balance;

    public GetUserResponse(UserDto dto, List<UserTransactionDto> transactions, double balance) {
        super(dto.getId(), dto.getName(), dto.getEmail());
        this.transactions = transactions;
        this.balance = balance;
    }
}
