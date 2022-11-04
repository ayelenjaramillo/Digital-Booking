package com.dh.CrudCategorias.models;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Categorias")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Categoria {

    @Id //@EmbededldId para clave compuesta
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String descripcion;

    //@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL) //
    private List<Producto> productos;

    //agregando constructor vacío por requerimiento
    public Categoria() {
    }

    public Categoria(CategoriaDTO categoriaDTO) {
        this.titulo= categoriaDTO.getTitulo();
        this.descripcion= categoriaDTO.getDescripcion();
        //this.urlImagen= categoriaDTO.getUrlImagen();

    }

    //eel que no tiene id lo utilizo para cargar info en la bbd
    public Categoria(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        //this.urlImagen = urlImagen;
    }

    public Categoria (Integer id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        //this.urlImagen = urlImagen;
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

    /*    public String getUrlImagen() {
        return urlImagen;
    }*/

    public void setId(Integer id) {
        this.id = id;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   /* public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }*/





}
