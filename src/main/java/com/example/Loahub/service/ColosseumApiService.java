package com.example.Loahub.service;

import com.example.Loahub.model.entity.UserTest;
import com.example.Loahub.model.network.Header;
import com.example.Loahub.model.network.request.ColosseumRequestDto;
import com.example.Loahub.model.network.response.ColosseumResponseDto;
import com.example.Loahub.model.repository.UserRepository;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColosseumApiService {
    @Autowired
    ColosseumsApiClient colosseumsApiClient;
    @Autowired
    UserRepository userRepository;

    public UserTest create(String characterName) throws ParseException{
        String result = colosseumsApiClient.readUrl(characterName);
        JSONObject competitive = colosseumsApiClient.parseJSON(result);

        UserTest user = new UserTest(
                characterName
                ,Integer.parseInt(String.valueOf(competitive.get("Rank")))
                ,competitive.get("RankName").toString()
                ,competitive.get("RankIcon").toString()
                ,Integer.parseInt(String.valueOf(competitive.get("RankLastMmr")))
                ,Integer.parseInt(String.valueOf(competitive.get("PlayCount")))
                ,Integer.parseInt(String.valueOf(competitive.get("VictoryCount")))
                ,Integer.parseInt(String.valueOf(competitive.get("LoseCount")))
                ,Integer.parseInt(String.valueOf(competitive.get("TieCount")))
                ,Integer.parseInt(String.valueOf(competitive.get("KillCount")))
                ,Integer.parseInt(String.valueOf(competitive.get("AceCount")))
                ,Integer.parseInt(String.valueOf(competitive.get("DeathCount"))));

                System.out.println(user.getCharacterName() + user.getRanking() + user.getRankName());
               userRepository.save(user);
               System.out.println(user.getCharacterName() + user.getRanking() + user. getRankName());
               return user;
    }

    public ColosseumResponseDto response(UserTest user, String characterName) throws ParseException{
        String result = colosseumsApiClient.readUrl(characterName);
        JSONObject competitive = colosseumsApiClient.parseJSON(result);

        ColosseumResponseDto colosseumResponseDto = ColosseumResponseDto.builder()
                .characterName(characterName)
                .ranking(Integer.parseInt(String.valueOf(competitive.get("Rank"))))
                .rankName((String)competitive.get("RankName"))
                .rankIcon((String)competitive.get("RankIcon"))
                .rankLastMmr(Integer.parseInt(String.valueOf(competitive.get("RankLastMmr"))))
                .playCount(Integer.parseInt(String.valueOf(competitive.get("PlayCount"))))
                .victoryCount(Integer.parseInt(String.valueOf(competitive.get("VictoryCount"))))
                .loseCount(Integer.parseInt(String.valueOf(competitive.get("LoseCount"))))
                .tieCount(Integer.parseInt(String.valueOf(competitive.get("TieCount"))))
                .killCount(Integer.parseInt(String.valueOf(competitive.get("KillCount"))))
                .aceCount(Integer.parseInt(String.valueOf(competitive.get("AceCount"))))
                .deathCount(Integer.parseInt(String.valueOf(competitive.get("DeathCount")))).build();

        return colosseumResponseDto;
    }

}