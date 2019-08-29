package com.codefellowship.codefellow.Controllers;

import com.codefellowship.codefellow.Models.ApplicationUser;
import com.codefellowship.codefellow.Models.ApplicationUserRepository;
import com.codefellowship.codefellow.Models.Post;
import com.codefellowship.codefellow.Models.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.sql.Date;
import java.text.SimpleDateFormat;

@Controller
public class PostController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    PostRepository postRepository;


    @GetMapping("/post/{id}")
    public String writePost(){
        return "posting";
    }

    @PostMapping("/post")
    public RedirectView createPost(String body, Principal user){
        ApplicationUser loggedInUser = applicationUserRepository.findByUsername(user.getName());
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        Post newPost = new Post(body, date,loggedInUser);
        postRepository.save(newPost);
        return new RedirectView("/user/" + loggedInUser.getId());
    }
}
