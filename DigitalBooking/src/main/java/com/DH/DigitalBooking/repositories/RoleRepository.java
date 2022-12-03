package com.DH.DigitalBooking.repositories;
import com.DH.DigitalBooking.models.Reservation;
import com.DH.DigitalBooking.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Object> {
 //TODO
 //Role findByName(String roleName);

}
