package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String rollDice() {

        return "rollDice";
    }
    @GetMapping("/roll-dice/{pick}")
    public String guesser(@PathVariable Integer pick, Model model) {
        model.addAttribute("pick", pick);
        model.addAttribute("random", (int)(Math.random()*((6-1)+1))+1);
        return "rollDice";
    }

}
