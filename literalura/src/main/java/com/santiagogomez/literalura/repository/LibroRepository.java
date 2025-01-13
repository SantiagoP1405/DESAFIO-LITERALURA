package com.santiagogomez.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santiagogomez.literalura.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

}
