package com.DH.DigitalBooking.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "features")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*@SequenceGenerator(name="feature_sequence",sequenceName = "feature_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "feature_sequence")*/
    private Long id;
    @Column
    private String description;
    @Column
    private String icon;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "products_id", referencedColumnName = "id")
    @JsonIgnore
    private Product product;

    public Feature(String description, String icon, Product product) {
        this.description = description;
        this.icon = icon;
        this.product = product;
    }


}
