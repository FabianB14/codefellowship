package com.codefellowship.codefellow.Models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    public Post findById(long id);
    public Post findByWriter(ApplicationUser user);
}
