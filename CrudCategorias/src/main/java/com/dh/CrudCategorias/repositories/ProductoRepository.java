package com.dh.CrudCategorias.repositories;
import com.dh.CrudCategorias.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository <Producto, Integer> {
}
