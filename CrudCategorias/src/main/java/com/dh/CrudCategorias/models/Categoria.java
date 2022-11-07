package com.dh.CrudCategorias.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Categorias")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Categoria {

    @Id//@EmbededldId para clave compuesta
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String titulo;
    @Column
    private String descripcion;
    @Column
    private String urlImagen;

    @JsonIgnore
    @OneToMany(mappedBy = "categoria",fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    @Column( name= "product_id")
    private Set<Producto> productos= new HashSet<>();

    //constructor VACÍO por requerimiento
    public Categoria() {
    }

    //constructor DTO
    public Categoria(CategoriaDTO categoriaDTO) {
        this.titulo= categoriaDTO.getTitulo();
        this.descripcion= categoriaDTO.getDescripcion();
        //this.urlImagen= categoriaDTO.getUrlImagen();

    }

    //Cconstructor SIN ID
    public Categoria(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }

    public Categoria (Integer id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        //this.urlImagen = urlImagen;
    }


    //GETTERS Y SETTERS
    public Integer getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getUrlImagen() {return urlImagen;}

    public void setId(Integer id) {
        this.id = id;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setUrlImagen(String urlImagen) {this.urlImagen = urlImagen;}





}
