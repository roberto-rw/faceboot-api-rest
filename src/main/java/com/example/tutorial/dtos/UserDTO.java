package com.example.tutorial.dtos;

import com.example.tutorial.entity.Role;
import com.example.tutorial.entity.Sex;

public class UserDTO {

    private Long id;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private String birthDate;
    private Sex sex;
    private byte[] image;
    private Role role;

    public UserDTO(){}

    public UserDTO(Long id, String name, String password,String email, String phoneNumber, String birthDate, Sex sex, byte[] image, Role role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.sex = sex;
        this.image = image;
        this.role = role;
    }

    public UserDTO(Long id, String name, String email, String phoneNumber, String birthDate, Sex sex, byte[] image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.sex = sex;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
