package com.DH.DigitalBooking.models;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

    @Getter
    @Setter
    @Entity
    @Table(name = "products")
    public class Product {
        @Id
        //@SequenceGenerator(name="image_sequence",sequenceName = "image_sequence",initialValue = 1)
        @SequenceGenerator(name="image_sequence",sequenceName = "image_sequence")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "image_sequence")
        @NotNull
        private Long id;
        @Column
        private String title;
        @NotBlank(message = "Category title cannot be null")
        @Column
        private String description_title;
        @Column
        private String description;
        @Column
        private Integer rating; //VALIDAR NUMERO
        @Column
        private String address;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "categories_id", referencedColumnName = "id")
        private Category category;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "cities_id", referencedColumnName = "id")
        private City city;

        //VALIDAR EXISTAN HACIENDO BUSQUEDA AL MOMENTO DE SETEAR
        @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
        private Set<Image> images = new HashSet<>();

        @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
        private Set<Feature> features = new HashSet<>();

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "policies_id", referencedColumnName = "id")
        private Policy policy;



        public Product() {
        }

        public Product(long id) {
            this.id = id;
        }

        public Product(String title, String description_title, String description, Integer rating, String address, Category category, City city, Set<Image> images, Set<Feature> features,Policy policy) {
            this.title = title;
            this.description_title = description_title;
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