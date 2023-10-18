package dev.mxtheuz.bank.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class HttpResponse {
    private int code;
    private String message;
    private Object content;
}
