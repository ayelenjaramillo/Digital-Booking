package com.DH.DigitalBooking.repositories;
import com.DH.DigitalBooking.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Object> {

    @Query("FROM Reservation r WHERE r.user.id = ?1")
    List<Reservation> findAllByUserId(long id);

    @Query("FROM Reservation r WHERE r.product.id = :product_id")
    List<Reservation> filterReservationsByProductId(@Param("product_id") Long product_id);

    //TODO OPCIONAL
   /* @Query("select r from reservation b where " +
            "((check_in_date between :check_in_date AND :check_out_date) " +
            "OR (check_out_date between :check_in_date AND :check_out_date) " +
            "OR ((:check_out_date between check_in_date AND check_out_date) AND " +
            "(:check_in_date between check_in_date AND check_out_date)) "+
            ") AND product_id = : id")
    List<Reservation> findByDatesBetweenWithProductId(
            @Param("check_in_date") LocalDate check_in_date,
            @Param("check_out_date") LocalDate check_out_date,
            @Param("product_id") Long id);
*/
}
