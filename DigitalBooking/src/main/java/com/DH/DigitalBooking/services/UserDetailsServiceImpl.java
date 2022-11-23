package com.DH.DigitalBooking.services;

import com.DH.DigitalBooking.models.dto.MainUserAuth;
import com.DH.DigitalBooking.models.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //inyecto a la interfaz que hace la bùsqueda del usuario
    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //el metodo sale del IUserRepository
        UserDTO user = userService.findByEmail(username);
        return MainUserAuth.build(user); //el usuario aquí se construye, y se llama al MainUserAuth que tiene la informacion
    }
    //se puede retornar el MainUserAuth porque si vamos a la clase vemos el implements
    //public class MainUserAuth implements UserDetails

}

