package com.dh.CrudCategorias.models;

public class CategoriaDTO {

    private Integer id;
    private String titulo;

    public CategoriaDTO(Integer id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.titulo = categoria.getTitulo();
    }
}
