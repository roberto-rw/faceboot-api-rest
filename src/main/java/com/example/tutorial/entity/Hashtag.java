//
//package com.example.tutorial.entity;
//
//import java.util.Objects;
//import javax.persistence.*;
//
//@Entity
//@Table(name="hashtags")
//public class Hashtag {
//    
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_hashtag")
//    private Long id;
//
//    @Column(name = "nombre")
//    private String nombre;
//
//    @ManyToOne (fetch = FetchType.EAGER)
//    @JoinColumn(name = "id_publicacion")
//    private Publicacion publicacion;
//    
//    public Hashtag() {}
//
//    public Hashtag(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public Hashtag(String nombre, Publicacion publicacion) {
//        this.nombre = nombre;
//        this.publicacion = publicacion;
//    }
//    
//    
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public Publicacion getPublicacion() {
//        return publicacion;
//    }
//
//    public void setPublicacion(Publicacion publicacion) {
//        this.publicacion = publicacion;
//    }
// 
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Hashtag hashtag = (Hashtag) o;
//        return id.equals(hashtag.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
//}
