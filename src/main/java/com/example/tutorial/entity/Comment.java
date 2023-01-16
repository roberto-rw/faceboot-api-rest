
package com.example.tutorial.entity;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "id_comment")
    private Long id;

    @Column( name = "date")
    private LocalDate date;

    @Column( name = "text")
    private String text;

    @Lob
    @Column( name = "image")
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_post")
    private Post post;

    public Comment(){}

    public Comment(Long id, LocalDate date, String text, byte[] image, User user, Post post) {
        this.id = id;
        this.date = date;
        this.text = text;
        this.image = image;
        this.user = user;
        this.post = post;
    }

    public Comment(LocalDate date, String text, byte[] image, User user, Post post) {
        this.date = date;
        this.text = text;
        this.image = image;
        this.user = user;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment that = (Comment) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
