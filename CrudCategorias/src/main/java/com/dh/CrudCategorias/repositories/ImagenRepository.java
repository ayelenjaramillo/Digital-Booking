package com.dh.CrudCategorias.repositories;

import com.dh.CrudCategorias.models.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepository extends JpaRepository <Imagen, Integer> {
}
