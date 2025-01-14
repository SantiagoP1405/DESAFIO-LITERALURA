package com.santiagogomez.literalura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

/*@Entity
@Table(name = "libros")*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro {
    //@Id
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String titulo;
    
    //@ManyToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonProperty("authors")
    private List<Autor> autores;
    @JsonProperty("languages")
    private List<String> idiomas;
    @JsonProperty("download_count")
    private Long descargas;

    public Libro(){

    }

    public Libro(Libro datosLibro){
        this.id = id;
        this.titulo = titulo;
        this.autores = autores;
        this.idiomas = idiomas;
        this.descargas = descargas;
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

    public void setTitulo(String titulo){
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

    public void setDescargas(Long descargas){
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
