package com.DH.DigitalBooking.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "images", schema= "0521PTC7N1db_GRUPO6") //no recomendable usar aqui indexes, uniqueConstrainsts/ External scripts and tools like Liquibase or Flyway are much better option to create or update database
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "image_generator")
    @SequenceGenerator(name="image_generator",sequenceName = "image_seq", allocationSize = 1)
    //@Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "title_image")
    private String title_image;
    @Column(name="url_image")
    private String url_image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "products_id", referencedColumnName = "id")
    @JsonIgnore
    private Product product;

    public Image(String title_image, String url_image, Product product) {
        this.title_image = title_image;
        this.url_image = url_image;
        this.product = product;
    }

}
