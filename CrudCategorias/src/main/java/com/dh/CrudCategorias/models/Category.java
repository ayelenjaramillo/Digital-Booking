package com.dh.CrudCategorias.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Categorias")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Category {

    @Id//@EmbededldId para clave compuesta
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String title;
    @Column
    private String description;
    @Column
    private String urlImage;

    @JsonIgnore
    @OneToMany(mappedBy = "category",fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    @Column( name= "product_id")
    private Set<Product> products = new HashSet<>();

    //constructor VACÍO por requerimiento
    public Category() {
    }

    //constructor DTO
    public Category(CategoryDTO categoryDTO) {
        this.title= categoryDTO.getTitle();
        this.description= categoryDTO.getDescription();
        //this.urlImagen= categoriaDTO.getUrlImagen();

    }

    //Cconstructor SIN ID
    public Category(String title, String description, String urlImage) {
        this.title = title;
        this.description = description;
        this.urlImage = urlImage;
    }

    public Category(Integer id, String title, String description,String urlImage) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.urlImage = urlImage;
    }


    //GETTERS Y SETTERS
    public Integer getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getUrlImage() {return urlImage;}

    public void setId(Integer id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setUrlImage(String urlImage) {this.urlImage = urlImage;}





}
