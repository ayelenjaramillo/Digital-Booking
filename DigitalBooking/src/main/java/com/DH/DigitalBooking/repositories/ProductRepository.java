package com.DH.DigitalBooking.repositories;
import com.DH.DigitalBooking.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository <Product, Long>{


    @Query("FROM Product p INNER JOIN Category c WITH p.category.id = c.id WHERE c.title = ?1")
    List<Product> filterProductsByCategoryTitle(String title);

    @Query("FROM Product p INNER JOIN City c WITH p.city.id = c.id WHERE c.cityName LIKE ?1")
    //@Query("FROM Product p INNER JOIN City c WITH p.city.id = c.id WHERE c.city_name LIKE ?1")
    List<Product> filterProductsByCityName(String cityName);

    @Query("FROM Product ORDER BY RAND()")
    List<Product> getRandomProducts();


}
