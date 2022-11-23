package com.DH.DigitalBooking.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private String snActive;

    private RoleDTO role;
}
