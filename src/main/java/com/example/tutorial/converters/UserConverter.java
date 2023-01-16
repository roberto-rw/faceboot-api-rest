package com.example.tutorial.converters;

import com.example.tutorial.dtos.UserDTO;
import com.example.tutorial.entity.Role;
import com.example.tutorial.entity.User;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class UserConverter extends AbstractConverter<User, UserDTO>{

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public UserDTO toDTO(User user) {
        return new UserDTO(user.getId(),user.getName(), user.getPassword(), user.getEmail(), user.getPhoneNumber(),
                            user.getBirthDate().toString(),user.getSex(), user.getImage(), Role.USER);
    }

    @Override
    public User toEntity(UserDTO dto) {
        return new User(dto.getId(),dto.getName(), passwordEncoder.encode(dto.getPassword()), dto.getEmail(), dto.getPhoneNumber(),
                       LocalDate.parse(dto.getBirthDate()),dto.getSex(), dto.getImage(), Role.USER);
    }
}
