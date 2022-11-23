package com.DH.DigitalBooking.models;

import com.DH.DigitalBooking.models.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User {
    @Id
    //@Column(name = "idUsers")
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //@Column(name = "name")
    @Column
    private String name;
    //@Column(name = "surname")
    @Column
    private String surname;
    //@Column(name = "email")
    @Column
    private String email;
    //@Column(name= "password")
    @Column
    private String password;
    //@Column(name = "city")
    @Column
    private String city;

    @ManyToOne
    //@JoinColumn(name = "Roles_idRoles")
    @JoinColumn
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Reservation> reservations = new HashSet<>();

    public User(long id){
        this.id = id;
    }

    /*public UserJwtResponseDTO toUserJwtReponseDTO(){
        return new UserJwtResponseDTO(this.getId(), this.getName(), this.getSurname(), this.getEmail(), this.getCity(), "admin".equals(role.getRole_name()));
    }*/

 /*   public UserCreationRequestDTO toUserCreationRequestDTO(){
       return new UserCreationRequestDTO(this.getName(), this.getSurname(), this.getEmail(), this.getPassword(), this.getCity(), this.getRole().getName());
    } */

}
