package com.santiagogomez.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Autor {
    private Integer nacimiento;
    private Integer defuncion;
    @JsonProperty("name")
    private String nombre;

    public Autor(){
    }

    public Autor(DatosAutor datosAutor){
        this.nacimiento = datosAutor.nacimiento();
        this.defuncion = datosAutor.defuncion();
        this.nombre = datosAutor.nombre();
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

    @Override
    public String toString(){
        return
                "Nombre: " + nombre + "\n" +
                "Fecha de Nacimiento: " + nacimiento + "\n" +
                "Fecha de Defuncion: " + defuncion + "\n";
    }
}
