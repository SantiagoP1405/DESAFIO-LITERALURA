package com.santiagogomez.literalura.principal;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.santiagogomez.literalura.service.ConsumoAPI;
import com.santiagogomez.literalura.service.ConvierteDatos;
import com.santiagogomez.literalura.model.*;
import com.santiagogomez.literalura.repository.LibroRepository;

@Component
public class Principal {
    private Scanner input = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String url = "https://gutendex.com/books/";
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private List<Libro> libros = new ArrayList<>();
    
    @Autowired
    private LibroRepository libroRepository;

    public void pruebaAPI() {
        System.out.println("Estos son los datos de la API");
        var json = consumoAPI.obtenerDatos(url);
        Results datos = convierteDatos.obtenerDatos(json, Results.class);
        libros = datos.getResults();
    
        // Mostrar todos los libros disponibles
        mostrarLibrosBuscados();
    
        // Solicitar al usuario el nombre del libro que desea buscar
        System.out.println("Escribe el nombre del libro que quieres buscar:");
        var nombreLibro = input.nextLine();
    
        // Buscar el libro por nombre
        Optional<Libro> libroEncontrado = libros.stream()
                .filter(libro -> libro.getTitulo().contains(nombreLibro))
                .findFirst();
    
        if (libroEncontrado.isPresent()) {
            var libro = libroEncontrado.get();
    
            // Verificar si el libro ya existe en la base de datos
            Optional<Libro> libroEnBaseDeDatos = libroRepository.findById(libro.getId());
    
            if (libroEnBaseDeDatos.isPresent()) {
                System.out.println("El libro con el nombre '" + libro.getTitulo() + "' ya existe en la base de datos.");
            } else {
                // Asegúrate de mantener la relación bidireccional entre el libro y los autores
                // Esto se hace añadiendo el libro a la lista de libros del autor.
                libro.getAutores().forEach(autor -> {
                    if (autor.getLibro() == null) {
                        autor.setLibro(new ArrayList<>());  // Inicializar la lista si es null
                    }
                    autor.getLibro().add(libro);  // Mantener la relación bidireccional
                });
    
                // Guardar el libro junto con los autores
                libroRepository.save(libro);
                System.out.println("Libro guardado: " + libro.getTitulo());
            }
        } else {
            System.out.println("No se encontró un libro con ese nombre.");
        }
    }
    

    // Método para mostrar los libros disponibles
    private void mostrarLibrosBuscados() {
        System.out.println("Lista de libros disponibles:");
        libros.forEach(libro -> System.out.println(libro.getTitulo()));
        System.out.println();
    }
}
