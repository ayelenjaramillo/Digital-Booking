package com.DH.DigitalBooking.models.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class MainUserAuth implements UserDetails {

    private String name;

    private String lastName;

    private String email;

    private String password;

    //esta collection de "autoridades" son los roles
    private Collection<? extends GrantedAuthority> authorities;

    //metodo para saber si es competente un usario
    public static MainUserAuth build(UserDTO user) {
        List<GrantedAuthority> authoritiesU = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getName());
        authoritiesU.add(authority);
        return new MainUserAuth(user.getName(), user.getSurname(), user.getEmail(), user.getPassword(), authoritiesU);
    }

    //Tienen que estar en TRUE
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}