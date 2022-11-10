package com.dh.CrudCategorias.models;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="productos")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "Producto_sequence", sequenceName = "Producto_sequence", allocationSize = 1)
    @Column
    private Integer id;

    private String title;
    private String adress;
    @Column(name="rating")
    private int rating;
    private String policy;


    // ATRIBUTOS CON RELACIONES
    //@ManyToOne(fetch = FetchType.LAZY)
    //@ManyToOne(fetch = FetchType.EAGER)
    //@JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categorias_id", referencedColumnName = "id")
    private Category category;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ciudades_id")
    private City city;
    private Set<City> cities = new HashSet<>();


    @OneToMany(mappedBy = "product",cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Image> images = new HashSet<>();


     /*@OneToMany(mappedBy = "producto",cascade = CascadeType.ALL, orphanRemoval = false)
   private Caracteristica caracteristica;*/
    // Lista de caracteristicas
    //generar la lista desde el controller valores staticos
    //llamar a la tabla con todas y hacer un hacer una nueva

    //construtor VACÍO
    public Product() {
    }

    //constructor ID
    public Product(Integer id){ this.id=id; }


    //constructor DTO
    /*public Producto(ProductoDTO productoDTO) {
        this.nombre = getNombre();
        this.direccion= getDireccion();
        this.categoriaEstablecimiento= getCategoriaEstablecimiento();
    } */
    //constructor SIN ID
    public Product(String title, String adress, Integer rating, String policy, Category category,City city, Set<Image> images) {
        this.title = title;
        this.adress = adress;
        this.rating = rating;
        this.policy= policy;
        this.category = category;
        this.city = city;
        this.images = images;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }
}
