package com.dh.CrudCategorias.models;
import com.fasterxml.jackson.annotation.JsonCreator;

public class ImageDTO {

    private Integer id;
    private String titulo;
    private String url;

    public ImageDTO() {
    }

    @JsonCreator
    public ImageDTO(String titulo, String url) {
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
