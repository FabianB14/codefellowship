package com.codefellowship.codefellow.Models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository <ApplicationUser, Long> {
    public ApplicationUser findByUsername(String username);
    public ApplicationUser findById(long id);

}
