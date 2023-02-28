package com.example.Loahub.controller.api;

import com.example.Loahub.service.ColosseumsApiClient;
import lombok.RequiredArgsConstructor;

import java.io.Console;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
@RequestMapping("/loahub")
public class ColosseumApiController {
    private final ColosseumsApiClient colosseumsApiClient;

    @GetMapping("/pvp")
    public String search(Model model) {

        model.addAttribute("data", "데이터입니다");
        return "searchDisplay";

    }

}
