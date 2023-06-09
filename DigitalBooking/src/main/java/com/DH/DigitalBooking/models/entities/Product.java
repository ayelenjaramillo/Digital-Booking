package com.DH.DigitalBooking.models.entities;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

    @Getter
    @Setter
    @Entity
    @Table(name = "products")
    public class Product {
        //Unable to find column with logical name: idProduct in org.hibernate.mapping.Table(products)
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        //@NotNull
        private Long id;
        @Column
        private String title;
        @NotBlank(message = "Category title cannot be null")
        @Column(name= "description_title")
        private String descriptionTitle;
        @Column
        private String description;
        @Column
        private Integer rating; //VALIDAR NUMERO
        @Column
        private String address;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "categories_id", referencedColumnName = "id")
        private Category category;

        @ManyToOne
        @JoinColumn(name = "cities_id", referencedColumnName = "id")
        //insertable = "false", updatable = "false"
        // para que no permita crear nuevos productos a través de esta relación sino que si queremos crear un nuevo cliente lo tengamos que hacer directamente en ese entity
        private City city;

        //VALIDAR EXISTAN HACIENDO BUSQUEDA AL MOMENTO DE SETEAR
        @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
        private Set<Image> images = new HashSet<>();

        @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
        private Set<Feature> features = new HashSet<>();

        @ManyToOne( cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
        @JoinColumn(name = "policies_id", referencedColumnName = "id")
        //insertable = "false", updatable = "false"
        // para que no permita crear nuevos productos a través de esta relación sino que si queremos crear un nuevo cliente lo tengamos que hacer directamente en ese entity
        private Policy policy;


        public Product() {
        }

        public Product(long id) {
            this.id = id;
        }

        public Product(String title, String descriptionTitle, String description, Integer rating, String address, Category category, City city, Set<Image> images, Set<Feature> features,Policy policy) {
            this.title = title;
            this.descriptionTitle = descriptionTitle;
            this.description = description;
            this.rating = rating;
            this.address = address;
            this.category = category;
            this.city = city;
            this.images = images;
            this.features = features;
            this.policy = policy;
        }

        //GETTERS Y SETTERS USADOS
        //get Id , set Id, set Category, set city, get images y set images

    }