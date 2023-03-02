package com.example.Loahub.controller.api;
import com.example.Loahub.model.entity.UserTest;
import com.example.Loahub.service.ColosseumApiService;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
@RequestMapping("/loahub")
public class ColosseumApiController {
    @Autowired
    ColosseumApiService colosseumApiService;

    @PostMapping("")
    public UserTest create(HttpServletRequest request) throws ParseException{
        String characterName = request.getParameter("nickname");
        return colosseumApiService.create(characterName);
    }


    @GetMapping("/pvp")
    public String search(UserTest user, Model model) throws ParseException{
        model.addAttribute("user",model);
        return "searchDisplay";
    }
}
