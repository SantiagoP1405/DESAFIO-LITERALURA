package com.santiagogomez.literalura.principal;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.santiagogomez.literalura.service.ConsumoAPI;
import com.santiagogomez.literalura.service.ConvierteDatos;
import com.santiagogomez.literalura.model.*;
import com.santiagogomez.literalura.repository.AutorRepository;
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

    @Autowired
    private AutorRepository autorRepository;

    public void muestraMenu(){
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Ver catálogo completo
                    2 - Buscar libro por título
                    3 - Ver libros registrados
                    4 - Ver autores registrados
                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = input.nextInt();
            input.nextLine();

            switch (opcion) {
                case 1:
                    //muestraCatalogo();
                    break;
                case 2:
                    //buscaLibroPorTitulo();
                    break;
                case 3:
                    //muestraLibrosRegistrados();
                    break;
                case 4:
                    //muestraAutoresRegistrados();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    public void pruebaAPI() {
        System.out.println("Estos son los datos de la API");
        var json = consumoAPI.obtenerDatos(url);
        Results datos = convierteDatos.obtenerDatos(json, Results.class);
        libros = datos.getResults();

        mostrarLibrosBuscados();
        System.out.println("Escribe el nombre del libro que quieres buscar:");
        var nombreLibro = input.nextLine().toLowerCase(); // Convertimos a minúsculas para la búsqueda

        Optional<Libro> libroEncontrado = libros.stream()
                .filter(libro -> libro.getTitulo().toLowerCase().contains(nombreLibro)) // Insensible a mayúsculas
                .findFirst();

        if (libroEncontrado.isPresent()) {
            var libro = libroEncontrado.get();

            Optional<Libro> libroEnBaseDeDatos = libroRepository.findById(libro.getId());
            if (libroEnBaseDeDatos.isPresent()) {
                System.out.println("El libro con el nombre '" + libro.getTitulo() + "' ya existe en la base de datos.");
            } else {
                procesarLibro(libro);
            }
        } else {
            System.out.println("No se encontró un libro con ese nombre.");
        }
    }

    private void procesarLibro(Libro libro) {
        // Actualizar o crear autores
        List<Autor> autoresActualizados = libro.getAutores().stream()
            .map(autor -> {
                Optional<Autor> autorExistente = autorRepository.findByNombre(autor.getNombre());
                return autorExistente.orElseGet(() -> autorRepository.save(autor));
            }).collect(Collectors.toList());

        // Asociar autores actualizados al libro
        libro.setAutores(autoresActualizados);

        // Guardar libro con autores actualizados
        libroRepository.save(libro);
        System.out.println("Libro guardado: " + libro.getTitulo());
    }

    private void mostrarLibrosBuscados() {
        System.out.println("Lista de libros disponibles:");
        libros.forEach(libro -> System.out.println(libro));
        System.out.println();
    }
}
