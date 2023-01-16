
package com.example.tutorial.dtos;


import java.util.List;

public class PostDTO {
    
    private Long id;
    private String username;
    private Long userId;
    private String date;
    private String text;
    private byte[] image;
    private List<CommentDTO> comments;

    public PostDTO() {
    }

    public PostDTO(Long id,String username, Long userId, String date, String text, byte[] image, List<CommentDTO> comments) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.date = date;
        this.text = text;
        this.image = image;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public List<CommentDTO> getCommentsDTO() {
        return comments;
    }

    public void setCommentsDTO(List<CommentDTO> comments) {
        this.comments = comments;
    }
}
