package com.DH.DigitalBooking.repositories;
import com.DH.DigitalBooking.models.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Object> {
 //TODO
 //Role findByName(String roleName);

}
