package com.santiagogomez.literalura.model;

public class Autor {
    private Long nacimiento;
    private Long defuncion;
    private String nombre;

    public Autor(){
    }

    public Autor(DatosAutor datosAutor){
        this.nacimiento = datosAutor.nacimiento();
        this.defuncion = datosAutor.defuncion();
        this.nombre = datosAutor.nombre();
    }

    public Long getNacimiento(){
        return nacimiento;
    }

    public void setNacimiento(Long nacimiento){
        this.nacimiento = nacimiento;
    }

    public Long getDefuncion(){
        return defuncion;
    }

    public void setDefuncion(Long defuncion){
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
