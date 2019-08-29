package com.codefellowship.codefellow.Controllers;

import com.codefellowship.codefellow.Models.ApplicationUser;
import com.codefellowship.codefellow.Models.ApplicationUserRepository;
import com.codefellowship.codefellow.Models.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    PostRepository postRepository;

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
}
