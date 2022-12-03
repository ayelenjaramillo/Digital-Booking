package com.DH.DigitalBooking.repositories;
import com.DH.DigitalBooking.models.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
    @Query("FROM Feature f WHERE f.product.id = ?1")
    List<Feature> findAllByProductId(long id);
}
