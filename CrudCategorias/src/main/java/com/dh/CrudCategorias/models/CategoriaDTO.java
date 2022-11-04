package com.dh.CrudCategorias.models;
import com.fasterxml.jackson.annotation.JsonCreator;

public class CategoriaDTO {

    private String titulo;
    private String descripcion;
    private String urlImagen;

    @JsonCreator
    public CategoriaDTO(String titulo, String descripcion, String urlImagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }


    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }


}
