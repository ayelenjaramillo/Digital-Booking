package com.dh.CrudCategorias.models;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ImagenDTO {

    private Integer id;
    private String titulo;
    private String url;

    public ImagenDTO() {
    }

    @JsonCreator
    public ImagenDTO(String titulo, String url) {
        this.titulo = titulo;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
