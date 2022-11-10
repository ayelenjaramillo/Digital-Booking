package com.dh.CrudCategorias.repositories;
import com.dh.CrudCategorias.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository <Product, Integer> {
    List<Product> buscarProductosPorCiudad(String nombre);

    List<Product> buscarProductosPorTituloDeCategoria(String titulo);
}
