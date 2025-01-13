package com.santiagogomez.literalura.principal;

import java.util.*;

import com.santiagogomez.literalura.service.ConsumoAPI;
import com.santiagogomez.literalura.service.ConvierteDatos;
import com.santiagogomez.literalura.model.*;
import com.santiagogomez.literalura.service.*;
public class Principal {
    private Scanner input = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String url = "https://gutendex.com/books/";
    //private final String url = "https://gutendex.com/books/";
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private List<DatosLibro> datosLibro = new ArrayList<>();
    private List<Libro> libro = new ArrayList<>();

    public void pruebaAPI(){
        System.out.println("Estos son los datos de la API");
        var json = consumoAPI.obtenerDatos(url);
        //System.out.println(json);
        Results datos = convierteDatos.obtenerDatos(json, Results.class);
        //System.out.println(datos);
        List<DatosLibro> libros = datos.getResults();
        for (DatosLibro datosLibro : libros) {
            System.out.println(datosLibro.toString());
            System.out.println();
            /*for (Autor autor : datosLibro.autores()) {
                System.out.println("  - Nombre: " + autor.getNombre());
                System.out.println("    Nacimiento: " + autor.getNacimiento());
                System.out.println("    Defunción: " + autor.getDefuncion());
            }*/
        }
    }
    
}
