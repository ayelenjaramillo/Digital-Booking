package com.DH.DigitalBooking.repositories;
import com.DH.DigitalBooking.models.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    //@Query("FROM Reservation r WHERE r.product.id =:productId")
    List<Reservation> findReservationByProductId(@Param("productId")Long id);

    //@Query("FROM Reservation r WHERE r.product.id = :product_id")
    List<Reservation> findByProductId(@Param("product_id") Long productId);
    //List<Reservation> findAllByProductId(Long productId);

    //@Query("FROM Reservation r WHERE r.user.id =:userId")
    List<Reservation> findReservationByUserId(@Param("usuarioId") Long id);

   // @Query("FROM Reservation r WHERE r.user.id = ?1")
    List<Reservation> findAllByUserId(Long id);


    List<Reservation> findByUserId(Long id);
    @Query (value = "select product_id from reservations where user_id = :userId", nativeQuery = true)
    List<Long> findByUserIdProduct(@Param("userId") Long userId);


    @Query("FROM Reservation r WHERE " +
            "(check_in_date between :checkInDate AND :checkOutDate) " +
            "OR (check_out_date between :checkInDate AND :checkOutDate) " +
            "OR ((:checkOutDate between check_in_Date AND check_out_date) AND (:checkInDate between check_in_date AND check_out_date))")
    List<Reservation> findByDatesBetween(@Param("checkInDate") LocalDate checkInDate, @Param("checkOutDate") LocalDate checkOutDate);

    @Query("select r from Reservation r where " +
            "((check_in_date between :checkInDate AND :checkOutDate) " +
            "OR (check_out_date between :checkInDate AND :checkOutDate) " +
            "OR ((:checkOutDate between check_in_date AND check_out_date) AND (:checkInDate between checkOutDate AND check_out_date)) "+
            ") AND product_id = :productId")
    List<Reservation> findByDatesBetweenAndProductId(
            @Param("checkInDate") LocalDate checkInDate,
            @Param("checkOutDate") LocalDate checkOutDate,
            @Param("productId") Long productId);

}













