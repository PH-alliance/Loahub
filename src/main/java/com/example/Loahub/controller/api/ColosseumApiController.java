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

    @PostMapping("/pvp")
    public UserTest create(HttpServletRequest request) throws ParseException{
        String characterName = request.getParameter("nickname");
        /*if(characterName == null){
            characterName = "깜찍쁘띠";
        }*/
        return colosseumApiService.create(characterName);
    }


    @GetMapping("/pvp")
    public String search(UserTest user, Model model) throws ParseException{
        model.addAttribute("rank",user.getRank());
        model.addAttribute("rankName",user.getRankName());
        model.addAttribute("rankIcon",user.getRankIcon());
        model.addAttribute("rankLastMmr",user.getRankLastMmr());
        model.addAttribute("playCount",user.getPlayCount());
        model.addAttribute("victoryCount",user.getVictoryCount());
        model.addAttribute("loseCount",user.getLoseCount());
        model.addAttribute("tieCount",user.getTieCount());
        model.addAttribute("killCount",user.getKillCount());
        model.addAttribute("aceCount",user.getAceCount());
        model.addAttribute("deathCount",user.getDeathCount()) ;

        return "searchDisplay";
    }
}
