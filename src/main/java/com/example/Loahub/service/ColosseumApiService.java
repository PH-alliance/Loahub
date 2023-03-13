package com.example.Loahub.service;

import com.example.Loahub.model.entity.UserTest;
import com.example.Loahub.model.network.Header;
import com.example.Loahub.model.network.response.ColosseumResponseDto;
import com.example.Loahub.model.repository.UserRepository;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
                user.setCharacterName(characterName)
                        .setRanking(Integer.parseInt(String.valueOf(competitive.get("Rank"))))
                        .setRankName(competitive.get("RankName").toString())
                        .setRankIcon(competitive.get("RankIcon").toString())
                        .setRankLastMmr(Integer.parseInt(String.valueOf(competitive.get("RankLastMmr"))))
                        .setPlayCount(Integer.parseInt(String.valueOf(competitive.get("PlayCount"))))
                        .setVictoryCount(Integer.parseInt(String.valueOf(competitive.get("VictoryCount"))))
                        .setLoseCount(Integer.parseInt(String.valueOf(competitive.get("LoseCount"))))
                        .setTieCount(Integer.parseInt(String.valueOf(competitive.get("TieCount"))))
                        .setKillCount(Integer.parseInt(String.valueOf(competitive.get("KillCount"))))
                        .setAceCount( Integer.parseInt(String.valueOf(competitive.get("AceCount"))))
                        .setDeathCount(Integer.parseInt(String.valueOf(competitive.get("DeathCount"))));

        //DB에 저장되는 순간.
        userRepository.save(user);

        //값 출력으로 확인
        System.out.println(user.getCharacterName());
        System.out.println(user.getRanking());
        System.out.println(user.getRankName());
        //여기까지는 값이 제대로 전달확인됨.

        return user;
        // 여기서 리턴 해줘도 전달이 안되는거같음. 어떻게 해결? 일단 이새끼가 문제인거 확실함.
        // response<User> 이런식으로 가거나 List<User> 이런식으로 리턴해주는거 시도해봐야겠음. << DB 내용 끌어다쓰려면 결국 List<UserTest>가 맞는거같긴함
        // 근데 List<UserTest>를 꼭 여기서 리턴해야하는가? 라는거에 대해선 굳이? 여기서 뭘 리턴해줘야할지 모르겠다.
        // 강의 빠르게 보면서 참고해야할것같음.
    }

   /*
    public Header<ColosseumResponseDto> read(String characterName) {
      return  userRepository.findByCharacterName(characterName)
              .
    }
    */

}