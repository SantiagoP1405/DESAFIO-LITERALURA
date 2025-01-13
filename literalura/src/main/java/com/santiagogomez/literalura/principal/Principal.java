package com.santiagogomez.literalura.principal;

import java.util.Scanner;

import com.santiagogomez.literalura.service.ConsumoAPI;
import com.santiagogomez.literalura.service.ConvierteDatos;

public class Principal {
    private Scanner input = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String url = "https://gutendex.com/books/";
    //private ConvierteDatos convierteDatos = new ConvierteDatos();

    public void pruebaAPI(){
        System.out.println("Estos son los datos de la API");
        var json = consumoAPI.obtenerDatos(url);
        System.out.println(json);
    }
    
}
