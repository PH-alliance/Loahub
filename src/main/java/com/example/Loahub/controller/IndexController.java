package com.example.Loahub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("loahub")
    public String index(){
        return "main";
    }
}