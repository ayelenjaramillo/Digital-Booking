package com.DH.DigitalBooking.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
    @SequenceGenerator(name = "category_sequence", sequenceName = "category_sequence", allocationSize = 0)
    //@Column(nullable = false)
    //@NotNull
    private Long id;
    @Column
    //@NotBlank
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
    public Category (String title, String description,String image_url) {
        this.title= title;
        this.description= description;
        this.image_url= image_url;
    }

    //constructor CON ID
  /*  public Category(Long id, String title, String description, String image_url) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image_url = image_url;
    }*/

}
