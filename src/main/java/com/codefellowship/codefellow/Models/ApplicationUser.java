package com.codefellowship.codefellow.Models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Collection;

@Entity
public class ApplicationUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstname;
    String lastname;
    String username;
    String password;
    Date dateOfBirth;
    String bio;

    public ApplicationUser(String firstname, String lastname,String username, String password, Date dateOfBirth, String bio){
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.bio = bio;
    }
    public ApplicationUser(){}
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getBio() {
        return bio;
    }
}
