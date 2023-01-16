
package com.example.tutorial.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name="publications")
public class Post {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_publication")
    private Long id;

    @ManyToOne
    @JoinColumn( name = "id_user")
    private User user;

    @Column( name = "date")
    private LocalDate date;

    @Column( name = "text")
    private String text;

    @Lob
    @Column( name = "image", length=1000000)
    private byte[] image;

    @OneToMany( mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comment> comments;
//
//    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<Etiqueta> etiquetas;
//    
//    @OneToMany(mappedBy = "publicacion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<Hashtag> hashtag;

    public Post() {}

    public Post(Long id) {
        this.id = id;
    }

    public Post(Long id, User user, LocalDate date, String text, byte[] image) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.text = text;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post that = (Post) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
