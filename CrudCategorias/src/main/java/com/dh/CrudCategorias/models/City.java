package com.dh.CrudCategorias.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Ciudades")
public class City {

    //@SequenceGenerator(name = "ciudad_sequence", sequenceName = "ciudad_sequence", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "idCiudades")
    private Integer id;
    private String nombre;
    private String pais;

   @OneToMany(mappedBy = "city",cascade = CascadeType.ALL)
   private List<Product> products;


    public City() {
    }

    //@Qualifier?
    public City(CityDTO ciudadDTO) {
        this.nombre = getNombre();
        this.pais = getPais();
    }

    //el que no tiene id lo utilizo para cargar info en la bbd
    public City(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    public City(Integer id, String nombre, String pais){
        this.id= id;
        this.nombre = nombre;
        this.pais = pais;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
