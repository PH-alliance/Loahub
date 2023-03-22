package com.example.Loahub.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Accessors(chain = true)
public class UserTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String characterName;
    private Integer ranking;
    private String rankName;
    private String rankIcon;
    private Integer rankLastMmr;
    private Integer playCount;
    private Integer victoryCount;
    private Integer loseCount;
    private Integer tieCount;
    private Integer killCount;
    private Integer aceCount;
    private Integer deathCount;

    private String characterImage;

    /*
    //추가기능
    private Integer victoryRate; //승률
    private Integer killRate; //목숨당 처치
    private Integer searchCount; //검색된 횟수
    // Todo : 그래프기능 추가
     */

    public UserTest(String characterName, Integer ranking, String rankName, String rankIcon, Integer rankLastMmr, Integer playCount,
                    Integer victoryCount, Integer loseCount, Integer tieCount, Integer killCount, Integer aceCount, Integer deathCount, String characterImage){
        this.characterName = characterName;
        this.ranking = ranking;
        this.rankName = rankName;
        this.rankIcon = rankIcon;
        this.rankLastMmr = rankLastMmr;
        this.playCount = playCount;
        this.victoryCount = victoryCount;
        this.loseCount = loseCount;
        this.tieCount = tieCount;
        this.killCount = killCount;
        this.aceCount = aceCount;
        this.deathCount = deathCount;
        this.characterImage = characterImage;
    }
}
