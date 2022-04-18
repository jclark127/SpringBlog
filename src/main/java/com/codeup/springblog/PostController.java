package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String posts(){
        return "Posts index page.";
    }

    @RequestMapping(path = "/posts{id}", method = RequestMethod.GET)
    @ResponseBody
    public String individualPosts(@PathVariable String id){
        return "View an individual post.";
    }

    @RequestMapping(path = "/create", method = RequestMethod.GET)
    @ResponseBody
    public String createGet(){
        return "View the form for creating a post";
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost(){
        return "Create a new post";
    }


}
