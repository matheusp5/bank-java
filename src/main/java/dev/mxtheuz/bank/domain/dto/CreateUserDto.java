package dev.mxtheuz.bank.domain.dto;

import lombok.ToString;

public record CreateUserDto(String name, String email, String password) {
}
