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

    public GetUserResponse(UserDto dto, List<UserTransactionDto> transactions) {
        super(dto.getId(), dto.getName(), dto.getEmail());
        this.transactions = transactions;
    }
}
