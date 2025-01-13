package com.santiagogomez.literalura.model;

import java.util.List;

import jakarta.persistence.*;

//@Entity
//@Table(name = "libro")
public class Libro {
    //@Id
    private Integer id;
    private String titulo;
    //@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Autor> autores;
    private List<String> idiomas;
    private Long descargas;

    public Libro(){

    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(){
        this.titulo = titulo;
    }

    public List<Autor> getAutores(){
        return autores;
    }

    public void setAutores(List<Autor> autores){
        this.autores = autores;
    }

    public List<String> getIdiomas(){
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas){
        this.idiomas = idiomas;
    }

    public Long getDescargas(){
        return descargas;
    }

    public void setDescargas(){
        this.descargas = descargas;
    }

    @Override
    public String toString(){
        return 
            "Título: " + titulo + "\n" +
            "Autor/Autora: " + autores + "\n" +
            "Idiomas: " + idiomas + "\n" +
            "Cantidad de descargas: " + descargas + "\n";
    }
}
