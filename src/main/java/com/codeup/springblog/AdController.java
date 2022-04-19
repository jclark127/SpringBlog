package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdController {
    private final AdRepository adDao;

    public AdController(AdRepository adDao) {
        this.adDao = adDao;
    }


    @GetMapping("/ad")
    public String ad(Model model){

        model.addAttribute("ads",adDao.findAll());

        return "adPage";
    }
}