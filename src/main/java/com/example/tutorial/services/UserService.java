
package com.example.tutorial.services;

import com.example.tutorial.converters.UserConverter;
import com.example.tutorial.dtos.LoginRequestDTO;
import com.example.tutorial.dtos.AuthenticationResponseDTO;
import com.example.tutorial.exceptions.NoDataFoundException;
import com.example.tutorial.exceptions.ValidateServiceException;
import com.example.tutorial.repositories.UserRepository;
import com.example.tutorial.dtos.UserDTO;
import com.example.tutorial.security.JWTUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import com.example.tutorial.entity.User;
import com.example.tutorial.validators.UserValidator;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Transactional
    public AuthenticationResponseDTO createUser(UserDTO userDTO){
        UserValidator.validateUser(userDTO);
        User existUser = userRepository.findByEmail(userDTO.getEmail()).orElse(null);
        if(existUser!=null) throw new ValidateServiceException("El email ya se encuentra registrado");
        User user = userConverter.toEntity(userDTO);
        User u = userRepository.save(user);
        UserDTO userResponse = userConverter.toDTO(u);
        var token = jwtUtils.generateToken(u);

        return new AuthenticationResponseDTO(userResponse, token);
    }

    public AuthenticationResponseDTO login(LoginRequestDTO request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new NoDataFoundException("Usuario no registrado"));
        UserDTO userResponse = userConverter.toDTO(user);
        var token = jwtUtils.generateToken(user);

        return new AuthenticationResponseDTO(userResponse, token);
    }
    
    public List<UserDTO> getUsers(){
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDTO = userConverter.toDTO(users);
        return usersDTO;
    }

}
