package com.example.tutorial.dtos;

import com.example.tutorial.entity.Post;
import com.example.tutorial.entity.User;

public class CommentDTO {
    private Long id;
    private String date;
    private String text;
    private byte[] image;
    private UserDTO user;
    private Long idPost;

    public CommentDTO(){}

    public CommentDTO(Long id, String date, String text, byte[] image, UserDTO user, Long idPost) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.image = image;
        this.user = user;
        this.idPost = idPost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }
}
