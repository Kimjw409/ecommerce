package com.knife.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {
    @GetMapping("/")
    String hello(){
        return "forward:/index.html";
    }

    @GetMapping("/about")
    @ResponseBody
    String about(){
        return "This is about page";
    }
}
