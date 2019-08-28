package com.codefellowship.codefellow.Controllers;

import com.codefellowship.codefellow.Models.ApplicationUser;
import com.codefellowship.codefellow.Models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;

@Controller

public class ApplicationUserController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/")
    public String home(Principal principal, Model model){
        if(principal != null) {
            ApplicationUser logedUser = applicationUserRepository.findByUsername(principal.getName());
            model.addAttribute("applicationUser", principal);
            System.out.println(principal.getName());
            model.addAttribute("user", logedUser);
            System.out.println(logedUser.getFirstname());
        }
        return "home";
    }
    @GetMapping("/users")
    public String reg(){
        return "registration";
    }
    @PostMapping("/registration")
    public RedirectView createUser(String firstname, String lastname, String username, String password, Date dateOfBirth, String bio){
        ApplicationUser newUser = new ApplicationUser(firstname, lastname, username,encoder.encode(password),dateOfBirth,bio);
        applicationUserRepository.save(newUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/");
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/user/{id}")
    public String userPage(@PathVariable long id, Model model ,Principal principal){
       ApplicationUser loggedinUser = applicationUserRepository.findByUsername(principal.getName());
       model.addAttribute("user", loggedinUser);
       System.out.println(loggedinUser.getUsername());
        return "userPage";
    }
}
