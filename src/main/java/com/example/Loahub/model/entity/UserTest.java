package com.example.Loahub.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.simple.JSONObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private JSONObject rank;
    private JSONObject rankName;
    private JSONObject rankIcon;
    private JSONObject rankLastMmr;
    private JSONObject playCount;
    private JSONObject victoryCount;
    private JSONObject loseCount;
    private JSONObject tieCount;
    private JSONObject killCount;
    private JSONObject aceCount;
    private JSONObject deathCount;

    /*
    //추가기능
    private Integer victoryRate; //승률
    private Integer killRate; //목숨당 처치
    private Integer searchCount; //검색된 횟수
    // Todo : 그래프기능 추가
     */
}
