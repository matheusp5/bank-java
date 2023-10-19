package dev.mxtheuz.bank.domain.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserDto {
    private String id;
    private String name;
    private String email;
}
