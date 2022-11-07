package com.DH.DigitalBooking.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "features")
public class Feature {
    @Id
    @SequenceGenerator(name="feature_sequence",sequenceName = "feature_sequence",initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "feature_sequence")
    private Long id;
    @Column
    private String description;
    @Column
    private String icon;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "products_id", referencedColumnName = "id")
    @JsonIgnore
    private Product product;

    public Feature() {
    }

    public Feature(String description, String icon, Product product) {
        this.description = description;
        this.icon = icon;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


}
