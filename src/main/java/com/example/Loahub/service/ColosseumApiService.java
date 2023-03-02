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
                .name(characterName)
                .rank((JSONObject) competitive.get("Rank"))
                .rankName((JSONObject)competitive.get("Rankname"))
                .rankIcon((JSONObject)competitive.get("RankIcon"))
                .rankLastMmr((JSONObject)competitive.get("RankLastMmr"))
                .playCount((JSONObject)competitive.get("PlayCount"))
                .victoryCount((JSONObject)competitive.get("VictoryCount"))
                .loseCount((JSONObject)competitive.get("LoseCount"))
                .tieCount((JSONObject)competitive.get("TieCount"))
                .killCount((JSONObject)competitive.get("KillCount"))
                .aceCount((JSONObject)competitive.get("AceCount"))
                .deathCount((JSONObject)competitive.get("DeathCount")).build();

               UserTest newUser = userRepository.save(user);
               return newUser;
    }

}