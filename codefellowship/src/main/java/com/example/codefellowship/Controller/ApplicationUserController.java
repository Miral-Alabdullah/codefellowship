package com.example.codefellowship.Controller;

import com.example.codefellowship.Model.ApplicationUser;
import com.example.codefellowship.Model.Post;
import com.example.codefellowship.Repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;


@Controller
public class ApplicationUserController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/signup")
    public RedirectView signUp(String username, String password, String firstName, String lastName,
                               String dateOfBirth, String bio, String imageUrl){
        ApplicationUser user = new ApplicationUser(username,bCryptPasswordEncoder.encode(password),
                                                   firstName, lastName, dateOfBirth, bio, imageUrl);
        applicationUserRepository.save(user);
        return new RedirectView("/login");
    }

    @PostMapping("/login")
    public String loggingIn(Model m, @RequestParam(value="username") String username){
        ApplicationUser user = applicationUserRepository.findByUsername(username);
        m.addAttribute("user",user);
        return "myprofile.html";
    }

    @GetMapping("/myprofile")
    public String getUserprofile(Principal p, Model m){
        try {
            ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
            m.addAttribute("user", user);
        } catch(Exception e){
            System.out.println(e);
        }
        return "myprofile.html";
    }



    @GetMapping("/users")
    public String getUsers(Principal p , Model m){
        ApplicationUser applicationUser = applicationUserRepository.findByUsername(p.getName());
        List<ApplicationUser> users = (List<ApplicationUser>) applicationUserRepository.findAll();
        m.addAttribute("applicationUser", applicationUser);
        m.addAttribute("allUsers", users);
        return "users.html";
    }

    @GetMapping("/users/{id}")
    public String getOneUser(@PathVariable int id, Principal p, Model m) {
        ApplicationUser targetedUser = applicationUserRepository.findById(id).get();
        ApplicationUser currentUser = applicationUserRepository.findByUsername(p.getName());
        m.addAttribute("targetedUser", targetedUser);
        m.addAttribute("currentUser", currentUser);
        return "user.html";
    }

    @GetMapping("/feed")
    public String getFeed(Principal p, Model m) {
        ApplicationUser applicationUser = applicationUserRepository.findByUsername(p.getName());
        m.addAttribute("applicationUser", applicationUser);
        return "feed.html";
    }

    
}
