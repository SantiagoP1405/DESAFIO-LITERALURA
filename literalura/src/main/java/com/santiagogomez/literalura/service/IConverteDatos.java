package com.santiagogomez.literalura.service;

public interface IConverteDatos {
    <T> T obtenerDatos(String json, Class<T> clase); //Retorna algo genérico
}
