package com.DH.DigitalBooking.controllers;

import com.DH.DigitalBooking.models.dto.UserDTO;
import com.DH.DigitalBooking.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserService userService;
    //necesitamos inyectar este passwordEncoder y asi puedo setear el password que viene en mi mismo objeto el cual yo envio a traves del postman,
    // en ese caso el password es 1234
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping()
    public ResponseEntity<Map<String,Object>> create(@RequestBody UserDTO user){
        Map<String, Object> response = new HashMap<>();
        //esta linea va a buscar el password
        String passWEncrypt = passwordEncoder.encode(user.getPassword());
        user.setPassword(passWEncrypt);
        response.put("respuesta",userService.save(user));
        return ResponseEntity.ok(response);
    }
}