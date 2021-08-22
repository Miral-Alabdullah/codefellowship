package com.example.codefellowship.Controller;

import com.example.codefellowship.Model.ApplicationUser;
import com.example.codefellowship.Model.Post;
import com.example.codefellowship.Repository.ApplicationUserRepository;
import com.example.codefellowship.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class PostController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PostRepository postRepository;

    @PostMapping("/addPost")
    public RedirectView createPost(Principal p, String body) {
        ApplicationUser applicationUser1 = applicationUserRepository.findByUsername(p.getName());
        Post post = new Post(body, applicationUser1);
        postRepository.save(post);
        return new RedirectView("/myprofile");
    }

    @GetMapping("/myprofile/{id}")
    public String getPost(Model m, @RequestParam(value = "id") Integer id) {
        ApplicationUser user = applicationUserRepository.findById(id).get();
        Post post = postRepository.findById(user.getId());
        m.addAttribute("post", post);
        return "post.html";
    }




}
