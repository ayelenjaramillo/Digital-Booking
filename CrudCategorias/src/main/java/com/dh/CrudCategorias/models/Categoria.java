package com.dh.CrudCategorias.models;

import javax.persistence.*;

@Entity
@Table(name="categorias")
public class Categoria {

    @Id //@EmbededldId para clave compuesta
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_sequence")
    @SequenceGenerator(name = "categoria_sequence", sequenceName = "categoria_sequence", allocationSize = 1)
    private Integer id;
    private String titulo;
    private String descripcion;
    @Column (name= "url_imagen") // Car= aclaro name porque en la tabla es diferente el nombre y puede traer problemas
    private String urlImagen;

    //agregando constructor vacío por requerimiento
    public Categoria() {
    }

    public Categoria(CategoriaDTO categoriaDTO) {
        this.titulo= categoriaDTO.getTitulo();
        this.descripcion= categoriaDTO.getDescripcion();
        this.urlImagen= categoriaDTO.getUrlImagen();

    }

    public Categoria(String titulo, String descripcion, String urlImagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }

    public Categoria(Integer id, String titulo, String descripcion, String urlImagen) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }

    public Integer getId() {
        return id;
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

    public void setId(Integer id) {
        this.id = id;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
