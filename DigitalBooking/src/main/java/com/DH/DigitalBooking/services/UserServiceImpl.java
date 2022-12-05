package com.DH.DigitalBooking.services;

import com.DH.DigitalBooking.models.entities.User;
import com.DH.DigitalBooking.models.dto.UserDTO;
import com.DH.DigitalBooking.repositories.UserRepository;
//import com.DH.DigitalBooking.util.MapperUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    //@Autowired
    //private MapperUtil mapperUtil;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {

        User user= mapper.convertValue(userDTO, User.class);
        user= userRepository.save(user);
        UserDTO userDTO1 = mapper.convertValue(user, UserDTO.class);

        return userDTO;
        //mapperUtil.map(userRepository.save(mapperUtil.map(user, User.class)), UserDTO.class);
    }

    @Override
    public UserDTO update(UserDTO user) {
        return null;
    }

    @Override
    public UserDTO delete(UserDTO user) {
        return null;
    }
    //devuelvo siempre un DTO adentro hago el casteo

    @Override
    public UserDTO findByEmail(String email) {return null;
            //mapperUtil.map(userRepository.findByEmail(email), UserDTO.class);

        // }
        }

    public User findById(Long id) {
        return null;

        //mapperUtil.map(userRepository.findById(id), User.class);
    }



}
