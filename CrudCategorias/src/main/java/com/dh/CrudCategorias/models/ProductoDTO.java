package com.dh.CrudCategorias.models;

public class ProductoDTO {


    private String nombre;
    private String direccion;

    public ProductoDTO(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

}
