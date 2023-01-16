
package com.example.tutorial.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;


@Entity
@Table(name="users")
public class User implements UserDetails {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_user")
    private Long id;

    @Column( name = "name")
    private String name;

    @Column( name = "password")
    private String password;

    @Column( name = "email")
    private String email;

    @Column( name = "phone_number")
    private String phoneNumber;

    @Column( name = "birth_date")
    private LocalDate birthDate;

    @Column( name = "sex")
    @Enumerated (EnumType.STRING)
    private Sex sex;

    @Lob
    @Column( name = "image")
    private byte[] image;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany( mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts;
//
//    @OneToMany( mappedBy = "etiquetado", cascade = CascadeType.ALL)
//    private List<Etiqueta> etiquetas;
//
//    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
//    private List<Comentario> comentarios;
    

    public User(){}

    public User(Long id, String name, String password, String email, String phoneNumber, LocalDate birthDate, Sex sex, byte[] image, Role role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.sex= sex;
        this.image = image;
        this.role = role;
    }

    public User(String name){
        this.name= name;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
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

    public List<Post> getPublications() {
        return posts;
    }

    public void setPublications(List<Post> posts) {
        this.posts = posts;
    }

    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
