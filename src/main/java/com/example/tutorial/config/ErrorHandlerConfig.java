package com.example.tutorial.config;

import com.example.tutorial.exceptions.GeneralServiceException;
import com.example.tutorial.exceptions.NoDataFoundException;
import com.example.tutorial.exceptions.ValidateServiceException;
import com.example.tutorial.utils.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandlerConfig extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> all(Exception e, WebRequest request){
        WrapperResponse<?> response = new WrapperResponse<>(e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(ValidateServiceException.class)
    public ResponseEntity<?> validateServiceException(ValidateServiceException e, WebRequest request){
        WrapperResponse<?> response = new WrapperResponse<>(e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<?> noDataFoundException(NoDataFoundException e, WebRequest request){
        WrapperResponse<?> response = new WrapperResponse<>(e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(GeneralServiceException.class)
    public ResponseEntity<?> generalServiceException(GeneralServiceException e, WebRequest request){
        WrapperResponse<?> response = new WrapperResponse<>(e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
