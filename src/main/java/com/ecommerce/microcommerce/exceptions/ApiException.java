package com.ecommerce.microcommerce.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
@Data
public class ApiException   {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private  final ZonedDateTime timestamp;
    public ApiException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime timestamp) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }


}
