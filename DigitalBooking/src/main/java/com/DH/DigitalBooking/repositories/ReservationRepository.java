package com.DH.DigitalBooking.repositories;
import com.DH.DigitalBooking.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Object> {

    @Query("FROM Reservation r WHERE r.user.id = ?1")
    List<Reservation> findAllByUserId(long id);

}
