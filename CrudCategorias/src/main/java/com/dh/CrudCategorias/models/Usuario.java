package com.dh.CrudCategorias.models;

import javax.persistence.*;

@Entity
@Table(name= "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Usuario_sequence")
    //@SequenceGenerator(name = "Usuario_sequence", sequenceName = "Usuario_sequence", allocationSize = 1)
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasenia;
}
