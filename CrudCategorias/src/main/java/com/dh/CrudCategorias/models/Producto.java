package com.dh.CrudCategorias.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Qualifier;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "Producto_sequence", sequenceName = "Producto_sequence", allocationSize = 1)
    @Column
    private Integer id;

    private String nombre;
    private String direccion;
    @Column(name="categoria_establecimiento")
    private int categoriaEstablecimiento;
    private String politica;
    private Boolean disponibilidad;

    // ATRIBUTOS CON RELACIONES
    //@ManyToOne(fetch = FetchType.LAZY)
    //@ManyToOne(fetch = FetchType.EAGER)
    //@JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categorias_id", referencedColumnName = "id")
    private Categoria categoria;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ciudades_id")
    private Ciudad ciudad;
    @OneToMany(mappedBy = "producto",cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Imagen> imagenes= new HashSet<>();

     /*@OneToMany(mappedBy = "producto",cascade = CascadeType.ALL, orphanRemoval = false)
   private Caracteristica caracteristica;*/
    // Lista de caracteristicas
    //generar la lista desde el controller valores staticos
    //llamar a la tabla con todas y hacer un hacer una nueva

    //construtor VACÍO
    public Producto() {
    }

    //constructor ID
    public Producto(Integer id){ this.id=id; }


    //constructor DTO
    /*public Producto(ProductoDTO productoDTO) {
        this.nombre = getNombre();
        this.direccion= getDireccion();
        this.categoriaEstablecimiento= getCategoriaEstablecimiento();
    } */
    //constructor SIN ID
    public Producto (String nombre, String direccion, Integer categoriaEstablecimiento,String politica, Boolean disponibilidad,Categoria categoria, Set<Imagen> imagenes) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.categoriaEstablecimiento = categoriaEstablecimiento;
        this.politica= politica;
        this.disponibilidad = disponibilidad;
        this.categoria= categoria;
        this.ciudad= ciudad;
        this.imagenes = imagenes;

    }


    /*  public Producto (Categoria categoria, Ciudad ciudad, Caracteristica caracteristica, String nombre, String direccion,Integer categoriaEstablecimiento){

        this.categoria = categoria;
        this.ciudad = ciudad;
        this.caracteristica = caracteristica;
        this.nombre = nombre;
        this.direccion = direccion;
        this.categoriaEstablecimiento  = categoriaEstablecimiento;

    }*/

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


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




}
