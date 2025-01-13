package com.santiagogomez.literalura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {
    private List<DatosLibro> results;

    public Results(){

    }

    public Results(DatosResults datosResults) {
        this.results = datosResults.results();
    }
    
    public List<DatosLibro> getResults() {
        return results;
    }

    public void setResults(List<DatosLibro> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ResultadoAPI{" +
                "results=" + results +
                '}';
    }
}

