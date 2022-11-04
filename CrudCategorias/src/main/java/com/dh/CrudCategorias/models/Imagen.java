package com.dh.CrudCategorias.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "Imagenes")
public class Imagen extends Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "Imagen_sequence", sequenceName = "Imagen_sequence", allocationSize = 1)
    private Integer id;
    private String titulo;
    private String url;

    /*@OneToMany(mappedBy = "imagen", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos;*/

    public Imagen() {
    }

    public Imagen(String titulo, String url) {
        this.titulo = titulo;
        this.url = url;
    }

    public Imagen(Integer id, String titulo, String url) {
        this.id = id;
        this.titulo = titulo;
        this.url = url;
    }

    public Integer getId() {return id;}

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
