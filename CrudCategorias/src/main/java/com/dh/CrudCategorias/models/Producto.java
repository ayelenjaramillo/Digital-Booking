package com.dh.CrudCategorias.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;


@Entity
@Table(name="Productos")
public class Producto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "Producto_sequence", sequenceName = "Producto_sequence", allocationSize = 1)
    private Integer id;

    //@ManyToOne(fetch = FetchType.EAGER)
  /*  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;*/

   /* @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ciudad")
    private Ciudad ciudad;
*/
/*    @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL, orphanRemoval = false)
    private Caracteristica caracteristica;*/

    private String nombre;
    private String direccion;

    @Column(name="categoria_establecimiento")
    private Integer categoriaEstablecimiento;

    private String politica;
    private Boolean disponibilidad;
    //@ManyToOne(fetch = FetchType.LAZY)

    /*@ManyToOne
    @JoinColumn(name = "imagen_id")
    private Imagen imagen;*/
    // Lista de caracteristicas
    //generar la lista desde el controller valores staticos
    //llamar a la tabla con todas y hacer un hacer una nueva


    public Producto() {
    }

    public Producto(ProductoDTO productoDTO) {
        this.nombre = getNombre();
        this.direccion= getDireccion();
        this.categoriaEstablecimiento= getCategoriaEstablecimiento();

    }

    public Producto(Integer id, Categoria categoria, String nombre, String direccion, Integer categoriaEstablecimiento) {
        this.id = id;
        //this.categoria = categoria;
        this.nombre = nombre;
        this.direccion = direccion;
        this.categoriaEstablecimiento = categoriaEstablecimiento;
    }

    public Producto( Categoria categoria, Ciudad ciudad, String nombre, String direccion, Integer categoriaEstablecimiento) {
        //this.categoria = categoria;
        //this.ciudad = ciudad;
        this.nombre = nombre;
        this.direccion = direccion;
        this.categoriaEstablecimiento = categoriaEstablecimiento;
    }

    public Producto(String nombre, String direccion, Integer categoriaEstablecimiento) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.categoriaEstablecimiento = categoriaEstablecimiento;
    }

    /*    public Producto (Categoria categoria, Ciudad ciudad, Caracteristica caracteristica, String direccion,Integer categoriaEstablecimiento){

        this.categoria = categoria;
        this.ciudad = ciudad;
        this.caracteristica = caracteristica;
        this.direccion = direccion;
        this.categoriaEstablecimiento  = categoriaEstablecimiento;

    }*/

    //eliminar set id?
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //public void setCategoria (Categoria categoria) {this.categoria = categoria;}

    //public void setCiudad (Ciudad ciudad){this.ciudad= ciudad;}

    //public void setCaracteristica(Caracteristica caracteristica){this.caracteristica= caracteristica;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCategoriaEstablecimiento() {
        return categoriaEstablecimiento;
    }

    public void setCategoriaEstablecimiento(Integer categoriaEstablecimiento) {
        this.categoriaEstablecimiento = categoriaEstablecimiento;
    }

/*    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }*/


    /*public Imagen getImagen() {
        return imagen;
    }*/

    //public Categoria getCategoria() {return categoria;}


}
