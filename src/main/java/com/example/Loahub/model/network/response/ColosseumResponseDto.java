package com.example.Loahub.model.network.response;
import lombok.Data;

@Data
public class ColosseumResponseDto {
    private String seasonName;
    private Competitive[] competitive;
    private Deathmatch[] deathmatch;

    @Data
    static class Competitive{
        private Integer rank;
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
    }

    @Data
    static class Deathmatch{
        private Integer playCount;
        private Integer victoryCount;
        private Integer loseCount;
        private Integer tieCount;
        private Integer killCount;
        private Integer aceCount;
        private Integer deathCount;
    }
}
