package com.DH.DigitalBooking.repositories;
import com.DH.DigitalBooking.models.City;
import com.DH.DigitalBooking.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository <City,Long>  {

    @Query("FROM Product p WHERE p.city.id = ?1")
    List<Product> findAllByCityId(long id);

}
