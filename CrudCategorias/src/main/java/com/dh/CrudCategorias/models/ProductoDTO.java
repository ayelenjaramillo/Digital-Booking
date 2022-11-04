package com.dh.CrudCategorias.models;
import com.fasterxml.jackson.annotation.JsonCreator;

public class ProductoDTO {

    //como un DTO podia contener información de múltiples fuentes/tablas y concentrarlas en una única clase simple,
    // quisiera que el producto DTO traiga las caracteristicas de alguna forma // duda sobre caracteristica como clase // pueden ir seteadas dentro de productoDTO?.
    //! Por las dudas Recordar que Date o Calendar no tienen una forma estándar para serializarse

    private String nombre;
    private String direccion;
    private String categoriaEstablecimiento;

    @JsonCreator
    public ProductoDTO(String nombre, String direccion,String categoriaEstablecimiento) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.categoriaEstablecimiento= categoriaEstablecimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCategoriaEstablecimiento(){ return categoriaEstablecimiento; }

}
