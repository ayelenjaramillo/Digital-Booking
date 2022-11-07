package com.dh.CrudCategorias.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name= "Imagenes")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "Imagen_sequence", sequenceName = "Imagen_sequence", allocationSize = 1)
    private Integer id;
    @Column
    private String title;
    private String url;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productos_id", referencedColumnName = "id")
    @JsonIgnore
    private Product product;


    public Image(){}

    public Image(ImageDTO imagenDTO) {
    }

    public Image(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public Image(String title, String url, Product product) {

        this.title = title;
        this.url = url;
        this.product = product;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Product getProduct() {return product;}

    public void setProduct(Product product) {
        this.product = product;
    }


}
