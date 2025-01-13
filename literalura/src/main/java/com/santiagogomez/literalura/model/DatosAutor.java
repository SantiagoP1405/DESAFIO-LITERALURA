package com.santiagogomez.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
    @JsonAlias("birth_year") Integer nacimiento,
    @JsonAlias("death_year") Integer defuncion,
    @JsonAlias("name") String nombre
) {
}
