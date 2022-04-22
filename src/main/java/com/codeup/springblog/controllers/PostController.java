package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostsRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostsRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;



    public PostController(PostsRepository postDao, UserRepository userDao,EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }


    @GetMapping(path = "/posts")
    public String posts(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping(path = "posts/{id}")
    public String individualPosts(@PathVariable String id, Model model){

        model.addAttribute("posts", postDao.getById(Long.parseLong(id)));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String postsCreate(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setOwner(user);
        postDao.save(post);
        emailService.prepareAndSend(post, "New post created!!!!",post.getBody());
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String postsEdit(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.getById(id));
        return "posts/edit";
    }


    @PostMapping("/posts/edit")
    public String updatePost(@ModelAttribute Post post){
        User user = userDao.getById((long) 1);
        post.setOwner(user);
        emailService.prepareAndSend(post, "Post has been Edited!!!!",post.getBody());
        postDao.save(post);
        return "redirect:/posts";
    }
}
