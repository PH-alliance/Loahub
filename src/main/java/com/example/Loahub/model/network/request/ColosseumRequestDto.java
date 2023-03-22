package com.example.Loahub.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ColosseumRequestDto {
    private String characterName;
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
