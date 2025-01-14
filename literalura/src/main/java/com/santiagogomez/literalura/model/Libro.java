package com.santiagogomez.literalura.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro {
    @Id
    @JsonProperty("id")
    private Long id;
    @JsonProperty("title")
    private String titulo;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
        name = "libros_autores",
        joinColumns = @JoinColumn(name = "libro_id"),
        inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    @JsonProperty("authors")
    private List<Autor> autores = new ArrayList<>();
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

    public Long getId(){
        return id;
    }

    public void setId(Long id){
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
public String toString() {
    return 
        "------- LIBRO ------- " + "\n" +
        "Título: " + titulo + "\n" +
        "Autor/Autora: " + autores.stream()
            .map(Autor::getNombre)
            .collect(Collectors.joining(", ")) + "\n" +
        "Idiomas: " + idiomas + "\n" +
        "Cantidad de descargas: " + descargas + "\n" + 
        "----------------------" + "\n";
}

}