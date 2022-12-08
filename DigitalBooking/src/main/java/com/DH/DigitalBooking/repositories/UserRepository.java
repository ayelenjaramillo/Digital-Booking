package com.DH.DigitalBooking.repositories;
import com.DH.DigitalBooking.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //el repositorio siempre nos devuelve una entidad
    //este metodo lo creamos para usar en el
    User findByEmail(String email);
}
