package com.codefellowship.codefellow.Models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String Body;
    Date createdAt;
    Integer likes;
    String comments;

    @ManyToOne
    ApplicationUser writer;

    public Post(String body, Date createdAt, ApplicationUser writer) {
        Body = body;
        this.createdAt = createdAt;
        this.writer = writer;
        this.likes = null;
        this.comments = null;
    }
}
