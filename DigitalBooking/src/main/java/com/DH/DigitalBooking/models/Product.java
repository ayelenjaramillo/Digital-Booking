package com.DH.DigitalBooking.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

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
        private Integer rating;
        @Column
        private String address;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "categories_id", referencedColumnName = "id")
        private Category category;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "cities_id", referencedColumnName = "id")
        private City city;

        @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
        private Set<Image> images = new HashSet<>();

        @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
        private Set<Feature> features = new HashSet<>();

        //@ManyToOne(fetch = FetchType.EAGER)
        //@JoinColumn(name = "policies_id", referencedColumnName = "id")
        //private Policy policy;

        private String policy;



        public Product() {
        }

        public Product(long id) {
            this.id = id;
        }

        public Product(String title, String description_title, String description, Integer rating, String address, Category category, City city, Set<Image> images, Set<Feature> features,String policy) {
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

        public String getDescription_title() {
            return description_title;
        }

        public void setDescription_title(String description_title) {
            this.description_title = description_title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getRating() {
            return rating;
        }

        public void setRating(Integer rating) {
            this.rating = rating;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        public City getCity() {
            return city;
        }

        public void setCity(City city) {
            this.city = city;
        }

        public Set<Image> getImages() {
            return images;
        }

        public void setImages(Set<Image> images) {
            this.images = images;
        }

        public Set<Feature> getFeatures() {return features;}

        public void setFeatures(Set<Feature> features) {this.features = features;}

        public String getPolicy() {
            return policy;
        }

        public void setPolicy(String policy) {
            this.policy = policy;
        }

    }