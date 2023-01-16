
//package com.example.tutorial.entity;
//
//import java.util.Objects;
//import javax.persistence.*;
//
//@Entity
//@Table(name="etiquetas")
//public class Etiqueta {
//    @Id
//    @GeneratedValue( strategy = GenerationType.IDENTITY )
//    @Column( name = "id_etiqueta")
//    private Long id;
//
//    @ManyToOne (fetch = FetchType.EAGER)
//    @JoinColumn( name = "id_publicacion")
//    private Publicacion publicacion;
//
//    @ManyToOne (fetch = FetchType.EAGER)
//    @JoinColumn( name = "id_etiquetado")
//    private Usuario etiquetado;
//
//    public Etiqueta(){
//    }
//    
//    public Etiqueta(Publicacion publicacion, Usuario etiquetado) {
//        this.publicacion = publicacion;
//        this.etiquetado = etiquetado;
//    }
//
//    public Etiqueta(Usuario etiquetado) {
//        this.etiquetado = etiquetado;
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
//    public Usuario getEtiquetado() {
//        return etiquetado;
//    }
//
//    public void setEtiquetado(Usuario etiquetado) {
//        this.etiquetado = etiquetado;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Etiqueta etiqueta = (Etiqueta) o;
//        return id.equals(etiqueta.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
//}
