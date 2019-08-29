package com.codefellowship.codefellow.Models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            // name is potato
            name="followed_users",
            // join columns: column where I find my own ID
            joinColumns = { @JoinColumn(name="userThatFollows") },
            // inverse: column where I find someone else's ID
            inverseJoinColumns = { @JoinColumn(name="") }
    )
    @OneToMany(fetch = FetchType.EAGER, mappedBy="writer")
    Set<Post> posts;


    public ApplicationUser(String firstname, String lastname, String username, String password, Date dateOfBirth, String bio){
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

    public Set<Post> getPosts() {
        return posts;
    }
    public String toString(){
        return this.getPosts().toString();
    }
}
