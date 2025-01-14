package com.santiagogomez.literalura.principal;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.santiagogomez.literalura.service.ConsumoAPI;
import com.santiagogomez.literalura.service.ConvierteDatos;
import com.santiagogomez.literalura.model.*;
//import com.santiagogomez.literalura.repository.LibroRepository;
import com.santiagogomez.literalura.service.*;
@Component
public class Principal {
    private Scanner input = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    //private final String url = "https://gutendex.com/books/";
    private final String url = "https://gutendex.com/books/";
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private List<Libro> libro = new ArrayList<>();
    /*@Autowired
    private LibroRepository libroRepository;*/



    public void pruebaAPI(){
        System.out.println("Estos son los datos de la API");
        var json = consumoAPI.obtenerDatos(url);
        //System.out.println(json);
        Results datos = convierteDatos.obtenerDatos(json, Results.class);
        //System.out.println(datos);
        libro = datos.getResults();
        for (Libro datosLibro : libro) {
            System.out.println(datosLibro.toString());
            System.out.println();
        }
    }
    
}
