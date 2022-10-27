package com.ecommerce.microcommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RequestApiException extends  RuntimeException{

    public RequestApiException(String message){
        super(message);
    }
    public  RequestApiException(String message ,Throwable throwable){
        super(message,throwable);
    }
}
