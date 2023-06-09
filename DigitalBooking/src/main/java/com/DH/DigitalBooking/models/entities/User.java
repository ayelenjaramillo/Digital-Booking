package com.DH.DigitalBooking.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "name")
    @Column
    private String name;
    //@Column(name = "surname")
    @Column
    private String surname;
    //@Column(name = "email")
    @Column(unique = true) //TODO FALTA EN BD
    @Email
    private String email; //es el username
    //@Column(name= "password")
    @Column
    private String password;
    //@Column(name = "city")
    @Column
    private String city;

    @ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "Roles_idRoles")
    @JoinColumn(name = "role_id")
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //TODO REVISAR EL CASCADE
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
