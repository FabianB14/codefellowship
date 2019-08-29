package com.codefellowship.codefellow.Models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String body;
    Date createdAt;
    Integer likes;
    String comments;

    @ManyToOne
    ApplicationUser writer;

    public Post(String body, Date createdAt, ApplicationUser writer) {
        this.body = body;
        this.createdAt = createdAt;
        this.writer = writer;
        this.likes = null;
        this.comments = null;
    }
    public Post(){}

    public long getId() {
        return id;
    }

    public String getBody() {
        return this.body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Integer getLikes() {
        return likes;
    }

    public String getComments() {
        return comments;
    }

    public ApplicationUser getWriter() {
        return writer;
    }
    public String toString(){
        return String.format("%s, has posted %s", this.getWriter().firstname, this.getBody());
    }
}
