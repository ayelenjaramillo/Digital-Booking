package com.DH.DigitalBooking.repositories;

import com.DH.DigitalBooking.models.Policy;
import com.DH.DigitalBooking.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {

    @Query("FROM Product p WHERE p.policy.id = ?1")
    List<Product> findAllByPolicyId(long id);
}
