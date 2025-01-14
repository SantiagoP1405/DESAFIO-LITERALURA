package com.santiagogomez.literalura.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "autores")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("birth_year")
    private Integer nacimiento;
    @JsonProperty("death_year")
    private Integer defuncion;
    @JsonProperty("name")
    private String nombre;
    @ManyToMany(fetch = FetchType.LAZY) // Relación bidireccional muchos a muchos
    @JoinTable(
        name = "libros_autores", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "autor_id"), // Columna para la clave foránea de autor
        inverseJoinColumns = @JoinColumn(name = "libro_id") // Columna para la clave foránea de libro
    )
     private List<Libro> libro = new ArrayList<>();

    public Autor(){
    }

    public Autor(Autor datosAutor){
        this.nacimiento = nacimiento;
        this.defuncion = defuncion;
        this.nombre = nombre;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Integer getNacimiento(){
        return nacimiento;
    }

    public void setNacimiento(Integer nacimiento){
        this.nacimiento = nacimiento;
    }

    public Integer getDefuncion(){
        return defuncion;
    }

    public void setDefuncion(Integer defuncion){
        this.defuncion = defuncion;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public List<Libro> getLibro(){
        return libro;
    }

    public void setLibro(List<Libro> libro){
        this.libro = libro;
    }

    @Override
    public String toString(){
        return nombre;
    }
}
