package com.example.Loahub.service;

import com.example.Loahub.model.entity.UserTest;
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

        UserTest user = new UserTest();
        UserTest.builder()
                .characterName(characterName)
                .ranking(Integer.parseInt(String.valueOf(competitive.get("Rank"))))
                .rankName((String)competitive.get("Rankname"))
                .rankIcon((String)competitive.get("RankIcon"))
                .rankLastMmr(Integer.parseInt(String.valueOf(competitive.get("RankLastMmr"))))
                .playCount(Integer.parseInt(String.valueOf(competitive.get("PlayCount"))))
                .victoryCount(Integer.parseInt(String.valueOf(competitive.get("VictoryCount"))))
                .loseCount(Integer.parseInt(String.valueOf(competitive.get("LoseCount"))))
                .tieCount(Integer.parseInt(String.valueOf(competitive.get("TieCount"))))
                .killCount(Integer.parseInt(String.valueOf(competitive.get("KillCount"))))
                .aceCount(Integer.parseInt(String.valueOf(competitive.get("AceCount"))))
                .deathCount(Integer.parseInt(String.valueOf(competitive.get("DeathCount")))).build();

               UserTest newUser = userRepository.save(user);
               return newUser;
    }

}