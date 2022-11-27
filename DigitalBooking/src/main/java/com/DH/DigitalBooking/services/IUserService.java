package com.DH.DigitalBooking.services;

import com.DH.DigitalBooking.models.dto.UserDTO;

import java.util.List;

public interface IUserService {

    public List<UserDTO> findAll();

    public UserDTO save(UserDTO user);

    public UserDTO update(UserDTO user);

    public UserDTO delete(UserDTO user);

    //acá tambien tenemos el findByCorreo
    public UserDTO findByEmail(String email);
}


