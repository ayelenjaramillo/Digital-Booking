package com.DH.DigitalBooking.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "Categories")
public class Category {

    @Id
    /*@SequenceGenerator(name="category_sequence",sequenceName = "category_sequence",initialValue = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")*/

    private Long id;
    @Column
    @NotNull
    private String title;
    @Column
    private String description;
    @Column
    private String image_url;

   /* @JsonIgnore
    @OneToMany(mappedBy = "categories",fetch= FetchType.EAGER, cascade = CascadeType.ALL)
    @Column( name= "product_id")
    private Set<Product> products= new HashSet<>();*/

    //constructor VACÍO por requerimiento
    public Category() {
    }

    //constructor SIN ID
    public Category(String title, String description,String image_url) {
        this.title= title;
        this.description= description;
        this.image_url= image_url;
    }

    //constructor CON ID
    public Category(Long id, String title, String description, String image_url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image_url = image_url;
    }

    //GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
