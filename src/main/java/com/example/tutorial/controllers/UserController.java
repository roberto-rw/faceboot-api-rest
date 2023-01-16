
package com.example.tutorial.controllers;

import com.example.tutorial.dtos.LoginRequestDTO;
import com.example.tutorial.dtos.AuthenticationResponseDTO;
import com.example.tutorial.dtos.UserDTO;
import com.example.tutorial.services.UserService;
import com.example.tutorial.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    
    @Autowired
    private UserService uService;
    
    @PostMapping(value="/signup")
    public ResponseEntity<WrapperResponse<AuthenticationResponseDTO>> createUser(@RequestBody UserDTO uDTO){
        AuthenticationResponseDTO authResponse = uService.createUser(uDTO);
        WrapperResponse<AuthenticationResponseDTO>response = new WrapperResponse<>("Usuario creado",authResponse);
        return response.createResponse(HttpStatus.CREATED);
    }

    @GetMapping(value = "/user")
    public ResponseEntity<WrapperResponse<List<UserDTO>>> getUsers(){
        List<UserDTO> users = uService.getUsers();
        WrapperResponse<List<UserDTO>>response = new WrapperResponse<>("Usuarios consultados",users);
        return response.createResponse(HttpStatus.OK);
    }

    @GetMapping(value = "/login")
    public ResponseEntity<WrapperResponse<AuthenticationResponseDTO>> login(@RequestBody LoginRequestDTO request) {
        AuthenticationResponseDTO authenticationResponseDTO = uService.login(request);
        WrapperResponse<AuthenticationResponseDTO> response = new WrapperResponse<>("Sesion iniciada", authenticationResponseDTO);
        return response.createResponse(HttpStatus.OK);
    }
}
