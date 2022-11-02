package com.dh.CrudCategorias.models;

import javax.persistence.*;

@Entity
@Table(name="Puntuaciones")
public class Puntuacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Imagen_sequence")
    @SequenceGenerator(name = "Imagen_sequence", sequenceName = "Imagen_sequence", allocationSize = 1)
    private Integer id;
}
