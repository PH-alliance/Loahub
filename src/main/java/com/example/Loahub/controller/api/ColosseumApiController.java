package com.example.Loahub.controller.api;
import com.example.Loahub.model.entity.UserTest;
import com.example.Loahub.model.repository.UserRepository;
import com.example.Loahub.service.ColosseumApiService;
import lombok.RequiredArgsConstructor;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/loahub")
public class ColosseumApiController {
    @Autowired
    ColosseumApiService colosseumApiService;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/pvp")

    public String create(HttpServletRequest request, Model model) throws ParseException{
        //프론트에서 검색한 캐릭터이름을 db에 생성 or 이미 있다면 받아오기
        String characterName = request.getParameter("nickname");
       // colosseumApiService.read(characterName);

        UserTest userTest;
        // colosseumApiService.read(characterName);

        if (userRepository.findByCharacterName(characterName).isPresent()) {
            userTest = colosseumApiService.read(characterName);
        } else {
            userTest = colosseumApiService.create(characterName);
        }

       //Controller 넘어오면서 데이터값이 모두 Null 이 됨.

        //출력으로 확인
        System.out.println(userTest.getCharacterName());
        System.out.println(userTest.getRanking());
        System.out.println(userTest.getRankName());
        System.out.println(userTest.getCharacterImage());

        model.addAttribute("characterName",characterName);
        model.addAttribute("rank", userTest.getRanking());
        model.addAttribute("rankName", userTest.getRankName());
        model.addAttribute("rankIcon", userTest.getRankIcon());
        model.addAttribute("rankLastMmr", userTest.getRankLastMmr());
        model.addAttribute("playCount", userTest.getPlayCount());
        model.addAttribute("victoryCount", userTest.getVictoryCount());
        model.addAttribute("loseCount", userTest.getLoseCount());
        model.addAttribute("tieCount", userTest.getTieCount());
        model.addAttribute("killCount", userTest.getKillCount());
        model.addAttribute("aceCount", userTest.getAceCount());
        model.addAttribute("deathCount", userTest.getDeathCount());
        model.addAttribute("characterImage",userTest.getCharacterImage());

        return "searchDisplay";
    }

    /*
    @GetMapping("/pvp")
    public String search(UserTest user, Model model) throws ParseException{

        System.out.println(user.getCharacterName());
        System.out.println(user.getRanking());
        System.out.println(user.getRankName());

        model.addAttribute("rank",user.getRanking());
        model.addAttribute("rankName",user.getRankName());
        model.addAttribute("rankIcon",user.getRankIcon());
        model.addAttribute("rankLastMmr",user.getRankLastMmr());
        model.addAttribute("playCount",user.getPlayCount());
        model.addAttribute("victoryCount",user.getVictoryCount());
        model.addAttribute("loseCount",user.getLoseCount());
        model.addAttribute("tieCount",user.getTieCount());
        model.addAttribute("killCount",user.getKillCount());
        model.addAttribute("aceCount",user.getAceCount());
        model.addAttribute("deathCount",user.getDeathCount());

        return "searchDisplay";

   }
*/

}

