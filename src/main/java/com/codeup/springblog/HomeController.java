package com.codeup.springblog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String landingMessage(){
        return "This is the landing page!";
    }
}
