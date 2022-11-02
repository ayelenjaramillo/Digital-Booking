package com.dh.CrudCategorias.models;

import javax.persistence.*;

@Entity
@Table(name="Productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Producto_sequence")
    @SequenceGenerator(name = "Producto_sequence", sequenceName = "Producto_sequence", allocationSize = 1)
    private Integer id;
    private String nombre;
    private String direccion;
    @Column(name="categoria_establecimiento")
    private String categoriaEstablecimiento;

    public Producto(ProductoDTO productoDTO) {
    }

    public Producto(String nombre, String direccion, String categoriaEstablecimiento) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.categoriaEstablecimiento = categoriaEstablecimiento;
    }

    public Producto(Integer id, String nombre, String direccion, String categoriaEstablecimiento) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.categoriaEstablecimiento = categoriaEstablecimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }
}
