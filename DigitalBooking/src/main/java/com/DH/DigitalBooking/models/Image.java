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
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //@Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(name = "title_image")
    private String titleImage;
    @Column(name="url_image")
    private String urlImage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "products_id", referencedColumnName = "id")
    @JsonIgnore
    private Product product;

    public Image(String titleImage, String urlImage, Product product) {
        this.titleImage = titleImage;
        this.urlImage = urlImage;
        this.product = product;
    }

}
