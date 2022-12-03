package com.DH.DigitalBooking.repositories;
import com.DH.DigitalBooking.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    /*@Query("FROM Reservation r WHERE r.user.id = ?1")
    List<Reservation> findAllByUserId(long id); */

    /*@Query("FROM Reservation r WHERE r.product.id = :product_id")
    List<Reservation> findByProductId(@Param("product_id") Long productId);*/


    @Query("select r from Reservation r where " +
            "(check_in_date between :checkInDate AND :checkOutDate) " +
            "OR (check_out_date between :checkInDate AND :checkOutDate) " +
            "OR ((:checkOutDate between check_in_Date AND check_out_date) AND (:checkInDate between check_in_date AND check_out_date))")

    List<Reservation> findByDatesBetween(
            @Param("checkInDate") LocalDate checkInDate,
            @Param("checkOutDate") LocalDate checkOutDate);


    List<Reservation> findByProductId(Long productId);
    @Query("select r from Reservation r where " +
            "((check_in_date between :checkInDate AND :checkOutDate) " +
            "OR (check_out_date between :checkInDate AND :checkOutDate) " +
            "OR ((:checkOutDate between check_in_date AND check_out_date) AND (:checkInDate between checkOutDate AND check_out_date)) "+
            ") AND product_id = :productId")

    List<Reservation> findByDatesBetweenAndProductId(
            @Param("checkInDate") LocalDate checkInDate,
            @Param("checkOutDate") LocalDate checkOutDate,
            @Param("productId") Long productId);

    List<Reservation> findAllByProductId(Long productId);
    List<Reservation> findByUserId(Long id);
    @Query (value = "select product_id from reservations where user_id = :userId", nativeQuery = true)
    List<Long> findByUserIdProduct(@Param("userId") Long userId);

}
