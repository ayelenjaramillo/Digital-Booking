package com.DH.DigitalBooking.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Roles")
public class Role {
    @Id
    //@Column(name = "idRoles")
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@Column(name = "role_name")
    @Column
    private String role_name;

    //TODO REVISAR SI SON NECESARIOS ESTOS DOS ATRIBUTOS
    /*@Column(name = "description")
    private String description;
    @Column(name = "snactive")
    private Boolean snactive;*/

    public Role(String role_name) {
        this.role_name = role_name;
    }

}
