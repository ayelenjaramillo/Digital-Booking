package com.dh.CrudCategorias.models;

import com.fasterxml.jackson.annotation.JsonCreator;

public class CityDTO {


    private String nombre;
    private String pais;

    public CityDTO() {
    }

    @JsonCreator
    public CityDTO(String nombre, String pais) {
        this.nombre = getNombre();
        this.pais = getPais();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }




}
