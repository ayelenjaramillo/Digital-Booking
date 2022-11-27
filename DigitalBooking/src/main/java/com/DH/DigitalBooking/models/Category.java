package com.DH.DigitalBooking.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
    //@SequenceGenerator(name = "category_sequence", sequenceName = "category_sequence", allocationSize = 0)
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

    //constructor SIN ID
    public Category (String title, String description,String image_url) {
        this.title= title;
        this.description= description;
        this.image_url= image_url;
    }



}
