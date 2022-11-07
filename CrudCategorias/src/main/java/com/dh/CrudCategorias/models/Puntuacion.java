package com.dh.CrudCategorias.models;

import javax.persistence.*;

@Entity
@Table(name="Puntuaciones")
public class Puntuacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "Imagen_sequence", sequenceName = "Imagen_sequence", allocationSize = 1)
    private Integer id;

    private Integer producto_id;
    private Integer usuario_id;
    private String puntuacion;

}
