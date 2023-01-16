package com.example.tutorial.utils;

import com.example.tutorial.dtos.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityManager;

public class WrapperResponse <T>{
    private String message;
    private T body;

    public WrapperResponse(String message, T body) {
        this.message = message;
        this.body = body;
    }

    public WrapperResponse() {
    }
    
    public ResponseEntity<WrapperResponse<T>> createResponse(HttpStatus status){
        return new ResponseEntity(this, status);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
