package com.santiagogomez.literalura.repository; 
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.santiagogomez.literalura.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNombre(String nombre);
}
