package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostsRepository postDao;

    public PostController(PostsRepository postDao) {
        this.postDao = postDao;
    }


    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String posts(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @RequestMapping(path = "/posts{id}", method = RequestMethod.GET)
    @ResponseBody
    public String individualPosts(@PathVariable String id){

        return "";
    }

    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public String createGet(){

        return "posts/create";
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String createPost(@RequestParam("title") String title, @RequestParam("body") String body, Model model){
        Post post = new Post(title, body);
        postDao.save(post);
        return "redirect:/posts";
    }


}
