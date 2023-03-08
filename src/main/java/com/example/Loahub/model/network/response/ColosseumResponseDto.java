package com.example.Loahub.model.network.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColosseumResponseDto {
    /*
    private String seasonName;
    private Competitive[] competitive;
    private TeamDeathmatch[] teamDeathmatches;
    private Deathmatch[] deathmatch;
    private TeamElimination[]     teamElimination;
    private CoOpBattle[] coOpBattle;
    @Data
    class Competitive{

     */
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
        /*
    }

    @Data
    class TeamDeathmatch{
        private Integer playCount;
        private Integer victoryCount;
        private Integer loseCount;
        private Integer tieCount;
        private Integer killCount;
        private Integer aceCount;
        private Integer deathCount;
    }

    @Data
    class Deathmatch{
        private Integer playCount;
        private Integer victoryCount;
        private Integer loseCount;
        private Integer tieCount;
        private Integer killCount;
        private Integer aceCount;
        private Integer deathCount;
    }

    @Data
    class TeamElimination {
        private Integer firstWinCount;
        private Integer secondWinCount;
        private Integer thirdWinCount;
        private Integer firstPlayCount;
        private Integer secondPlayCount;
        private Integer thirdPlayCount;
        private Integer allKillCount;
        private Integer playCount;
        private Integer victoryCount;
        private Integer loseCount;
        private Integer tieCount;
        private Integer killCount;
        private Integer aceCount;
        private Integer deathCount;
    }

    @Data
    class CoOpBattle{
        private Integer playCount;
        private Integer victoryCount;
        private Integer loseCount;
        private Integer tieCount;
        private Integer killCount;
        private Integer aceCount;
        private Integer deathCount;
    }

 */
}