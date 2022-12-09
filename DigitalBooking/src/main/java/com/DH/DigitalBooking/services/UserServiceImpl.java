package com.DH.DigitalBooking.services;

import com.DH.DigitalBooking.exceptions.ResourceNotFoundException;
import com.DH.DigitalBooking.models.entities.Product;
import com.DH.DigitalBooking.models.entities.User;
import com.DH.DigitalBooking.models.dto.UserDTO;
import com.DH.DigitalBooking.repositories.UserRepository;
//import com.DH.DigitalBooking.util.MapperUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        //mapperUtil.map(userRepository.save(mapperUtil.map(user, User.class)), UserDTO.class);
        User user= mapper.convertValue(userDTO, User.class);
        user= userRepository.save(user);
        UserDTO userDTO1 = mapper.convertValue(user, UserDTO.class);
        return userDTO;

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
    public UserDTO findByEmail(String email) {
            //mapperUtil.map(userRepository.findByEmail(email), UserDTO.class); // }
        User user= mapper.convertValue(userRepository.findByEmail(email), User.class);
        UserDTO userDTO= mapper.convertValue(user,UserDTO.class);

        return userDTO;

        }

    public User findById(Long id) throws ResourceNotFoundException{
        //mapperUtil.map(userRepository.findById(id), User.class);
        Optional<User> result= userRepository.findById(id);
        if(result.isPresent())
        {return result.get();}else {
        throw new ResourceNotFoundException("Could not find specified resource.");}

    }




}
