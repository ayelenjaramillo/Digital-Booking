package com.dh.CrudCategorias.models;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.HashSet;
import java.util.Set;


//@AllArgsConstructor
//@NoArgsConstructor
// Esta anotación es útil principalmente en combinación con uno @Data u otro de los otros constructores que generan anotaciones.
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//Para agregar un modificador de acceso a cada campo (instancia), use @FieldDefaults(level=AccessLevel.PRIVATE). Cualquier campo que aún no tenga un modificador de acceso (es decir, cualquier campo que parezca un paquete de acceso privado) se cambia para tener el modificador de acceso apropiado.
//@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductoDTO extends Producto{

    //como un DTO podia contener información de múltiples fuentes/tablas y concentrarlas en una única clase simple,
    // quisiera que el producto DTO traiga las caracteristicas de alguna forma // duda sobre caracteristica como clase // pueden ir seteadas dentro de productoDTO?.
    //! Por las dudas Recordar que Date o Calendar no tienen una forma estándar para serializarse

    private String nombre;
    private String direccion;
    private Integer categoriaEstablecimiento;
    private Integer categoria_id;
    private Integer ciudad_id;
    private Set<Imagen> imagenes_id = new HashSet<>();


    public ProductoDTO(){}

    @JsonCreator
    public ProductoDTO(String nombre, String direccion,Integer categoriaEstablecimiento, Integer categoria_id, Integer ciudad_Id,Set<Imagen> imagenes_id) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.categoriaEstablecimiento= categoriaEstablecimiento;
        this.categoria_id= categoria_id;
        this.ciudad_id= ciudad_id;
        this.imagenes_id= imagenes_id;
    }


    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public Integer getCategoriaEstablecimiento(){ return categoriaEstablecimiento; }

    public Integer getCategoria_id() {return categoria_id;}

    public Integer getCiudad_id() {return ciudad_id;}

    public Set<Imagen> getImagenes() {return imagenes_id;}


   /* public Producto toProducto (){
        return new Producto(nombre,direccion,categoriaEstablecimiento,
        new Categoria(categoria_id,null, null),
                new Ciudad(ciudad_id,null, null)}*/

}
