package com.codeup.springblog;

import org.springframework.web.bind.annotation.*;

public class MathControllerClass {

    @RequestMapping(path = "/add/{n1}/and/{n2}", method = RequestMethod.GET)
    @ResponseBody
    public int add(@PathVariable int n1, @PathVariable int n2){
        return n1 + n2;
    }

    @RequestMapping(path = "/add/{n1}/and/{n2}", method = RequestMethod.GET)
    @ResponseBody
    public int subtract(@PathVariable int n1, @PathVariable int n2){
        return n1 - n2;
    }

    @RequestMapping(path = "/add/{n1}/and/{n2}", method = RequestMethod.GET)
    @ResponseBody
    public int multiply(@PathVariable int n1, @PathVariable int n2){
        return n1 * n2;
    }

    @RequestMapping(path = "/add/{n1}/and/{n2}", method = RequestMethod.GET)
    @ResponseBody
    public int divide(@PathVariable int n1, @PathVariable int n2){
        return n1 / n2;
    }
}
