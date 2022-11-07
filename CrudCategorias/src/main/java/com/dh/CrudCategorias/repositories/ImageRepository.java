package com.dh.CrudCategorias.repositories;

import com.dh.CrudCategorias.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository <Image, Integer> {
}
