package com.DH.DigitalBooking.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @SequenceGenerator(name="image_sequence",sequenceName = "image_sequence",initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "image_sequence")
    private Long id;
    @Column
    private String title_image;
    @Column
    private String url_image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "products_id", referencedColumnName = "id")
    @JsonIgnore
    private Product product;

    public Image() {
    }

    public Image(String title_image, String url_image, Product product) {
        this.title_image = title_image;
        this.url_image = url_image;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle_image() {
        return title_image;
    }

    public void setTitle_image(String title_image) {
        this.title_image = title_image;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
