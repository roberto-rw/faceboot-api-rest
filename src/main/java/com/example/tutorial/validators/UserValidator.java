package com.example.tutorial.validators;

import com.example.tutorial.dtos.UserDTO;
import com.example.tutorial.exceptions.ValidateServiceException;


public class UserValidator {
    public static void validateUser(UserDTO u){
        
        if(u == null){
            throw new ValidateServiceException("Usuario nulo");
        }

        if(u.getName()==null || u.getBirthDate()==null || u.getEmail()==null|| u.getPassword()==null || u.getPhoneNumber() ==null || u.getSex() == null)
        {
            throw new ValidateServiceException("Informacion no valida");
        }

        if(!DateValidator.validateDate(u.getBirthDate())){
            throw new ValidateServiceException("Formato de fecha incorrecto");
        }
    }
}
