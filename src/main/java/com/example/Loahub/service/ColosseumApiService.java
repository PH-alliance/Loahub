package com.example.Loahub.service;

import com.example.Loahub.model.entity.UserTest;
import com.example.Loahub.model.repository.UserRepository;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColosseumApiService {
    @Autowired
    ColosseumsApiClient colosseumsApiClient;
    @Autowired
    UserRepository userRepository;

    public UserTest create(String characterName) throws ParseException {
        // 캐릭터 이름이 존재하면 값 불러오기

        //return userRepository.findByCharacterName(characterName)

        {
            // 그렇지않다면 db테이블에 생성
            String result = colosseumsApiClient.readUrl(characterName);
            JSONObject competitive = colosseumsApiClient.parseCompetitive(result);

            String charRes = colosseumsApiClient.readCharacter(characterName);
            String character = colosseumsApiClient.parseCharacter(charRes);

            UserTest userTest = new UserTest();
            userTest.setCharacterName(characterName)
                    .setRanking(Integer.parseInt(String.valueOf(competitive.get("Rank"))))
                    .setRankName(competitive.get("RankName").toString())
                    .setRankIcon(competitive.get("RankIcon").toString())
                    .setRankLastMmr(Integer.parseInt(String.valueOf(competitive.get("RankLastMmr"))))
                    .setPlayCount(Integer.parseInt(String.valueOf(competitive.get("PlayCount"))))
                    .setVictoryCount(Integer.parseInt(String.valueOf(competitive.get("VictoryCount"))))
                    .setLoseCount(Integer.parseInt(String.valueOf(competitive.get("LoseCount"))))
                    .setTieCount(Integer.parseInt(String.valueOf(competitive.get("TieCount"))))
                    .setKillCount(Integer.parseInt(String.valueOf(competitive.get("KillCount"))))
                    .setAceCount(Integer.parseInt(String.valueOf(competitive.get("AceCount"))))
                    .setDeathCount(Integer.parseInt(String.valueOf(competitive.get("DeathCount"))))
                    .setCharacterImage(character);

            //DB에 저장되는 순간.
            userRepository.save(userTest);

            return userTest;
            // 리턴을 List<UserTest> 로 바꿔주고 read 와 이지선다걸어서 model.addadttribute("list", list) 이런식으로 줘야할것같음.
        }
    }

    public UserTest read(String characterName){
        UserTest userTest = new UserTest();
        Optional<UserTest> optional = userRepository.getByCharacterName(characterName);

        userTest.setCharacterName(optional.get().getCharacterName())
                .setRanking(optional.get().getRanking())
                .setRankName(optional.get().getRankName())
                .setRankIcon(optional.get().getRankIcon())
                .setRankLastMmr(optional.get().getRankLastMmr())
                .setPlayCount(optional.get().getPlayCount())
                .setVictoryCount(optional.get().getVictoryCount())
                .setLoseCount(optional.get().getLoseCount())
                .setTieCount(optional.get().getTieCount())
                .setKillCount(optional.get().getKillCount())
                .setAceCount(optional.get().getAceCount())
                .setDeathCount(optional.get().getDeathCount())
                .setCharacterImage(optional.get().getCharacterImage());

        return userTest;
    }
}