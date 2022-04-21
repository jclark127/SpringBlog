package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostsRepository postDao;
    private final UserRepository userDao;

    public PostController(PostsRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }


    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String posts(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String individualPosts(@PathVariable String id, Model model){

        model.addAttribute("posts", postDao.getById(Long.parseLong(id)));
        return "posts/show";
    }

    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public String createGet(Model model){

        return "posts/create";
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String createPost(@RequestParam("title") String title, @RequestParam("body") String body){
        Post post = new Post(title, body, new User(1,"User1", "j@b.com", "pass"));
        postDao.save(post);
        return "redirect:/posts/" + post.getId();
    }


}
