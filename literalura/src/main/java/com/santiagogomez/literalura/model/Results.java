package com.santiagogomez.literalura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {
    @JsonProperty("results")
    private List<Libro> results;

    public Results(){

    }

    public Results(Results datosResults) {
        this.results = results;
    }
    
    public List<Libro> getResults() {
        return results;
    }

    public void setResults(List<Libro> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ResultadoAPI{" +
                "results=" + results +
                '}';
    }
}

