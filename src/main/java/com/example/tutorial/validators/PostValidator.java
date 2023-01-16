
package com.example.tutorial.validators;

import com.example.tutorial.dtos.PostDTO;
import com.example.tutorial.exceptions.ValidateServiceException;

public class PostValidator {
    public static void createPost(PostDTO p){
        if(p == null){
            throw new ValidateServiceException("Publicacion nula");
        }      
        if (p.getText() == null) {
            throw new ValidateServiceException("Informacion no valida");
        }
    }
    
    public static void updatePost(PostDTO p){
        if(p==null){
            throw new ValidateServiceException("Publicacion nula");
        }   
        if(p.getText() == null || p.getId() == null || p.getDate() == null){
            throw new ValidateServiceException("Informacion no valida");
        }
        if(!DateValidator.validateDate(p.getDate())){
            throw new ValidateServiceException("Formato de fecha incorrecto");
        }
    }
}
