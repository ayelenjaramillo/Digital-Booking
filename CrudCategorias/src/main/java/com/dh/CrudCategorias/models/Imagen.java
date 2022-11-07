package com.dh.CrudCategorias.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "Imagenes")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "Imagen_sequence", sequenceName = "Imagen_sequence", allocationSize = 1)
    private Integer id;
    @Column
    private String titulo;
    private String url;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productos_id", referencedColumnName = "id")
    @JsonIgnore
    private Producto producto;


    public Imagen(){}

    public Imagen(ImagenDTO imagenDTO) {
    }

    public Imagen(String titulo, String url) {
        this.titulo = titulo;
        this.url = url;
    }

    public Imagen(String titulo, String url, Producto producto) {

        this.titulo = titulo;
        this.url = url;
        this.producto= producto;
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

    public Producto getProducto() {return producto;}

    public void setProducto(Producto producto) {
        this.producto = producto;
    }


}
