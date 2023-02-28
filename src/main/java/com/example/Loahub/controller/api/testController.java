package com.example.Loahub.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Loahub.service.ColosseumsApiClient;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")

public class testController {

    private final ColosseumsApiClient colosseumsApiClient;

    @GetMapping("/pvp")
    public String search() {
        return "searchDisplay";
    }

}
