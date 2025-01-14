package com.santiagogomez.literalura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.santiagogomez.literalura.model.Libro;
@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    @Query(
        value = """
                SELECT l.* 
                FROM libros l
                JOIN libros_autores la ON l.id = la.libro_id
                JOIN autores a ON la.autor_id = a.id
                ORDER BY a.nombre ASC, l.titulo ASC
                """, 
        nativeQuery = true
    )
    List<Libro> findLibrosOrdenadosPorAutor();
}
