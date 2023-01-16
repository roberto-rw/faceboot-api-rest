package com.example.tutorial.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class GeneralServiceException extends RuntimeException{
    public GeneralServiceException(String message){
        super(message);
    }
}
