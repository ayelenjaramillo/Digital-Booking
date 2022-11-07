package com.dh.CrudCategorias.repositories;
import com.dh.CrudCategorias.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository <Producto, Integer> {
    List<Producto> buscarProductosPorCiudad(String nombre);

    List<Producto> buscarProductosPorTituloDeCategoria(String titulo);
}
