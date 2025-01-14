package com.santiagogomez.literalura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.santiagogomez.literalura.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long>{
    @Query(
        value = """
            SELECT * FROM libros 
            WHERE ?1 = ANY(idiomas::text[]);
        """, 
        nativeQuery = true
    )
    List<Libro> findLibrosPorIdioma(String idioma);
}
