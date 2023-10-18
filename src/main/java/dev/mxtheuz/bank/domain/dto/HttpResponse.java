package dev.mxtheuz.bank.domain.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HttpResponse {
    private int code;
    private String message;
    private Object content;
}
