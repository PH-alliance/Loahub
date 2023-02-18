package com.example.Loahub.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Header<T> {
    private Integer rank;
    private Integer preRank;
    private Integer exp;
    private List<T> colosseum;
    private String description;

    public static <T> Header<T> OK(){
        return (Header<T>)Header.builder()
                .rank(0)
                .preRank(0)
                .exp(0)
                .build();
    }

    public static <T> Header<T> OK(T colosseum){
        return (Header<T>)Header.builder()
                .rank(0)
                .preRank(0)
                .exp(0)
                .colosseum()
                .build();
    }

    public static <T> Header<T> ERROR(String description){
        return (Header<T>)Header.builder()
                .description(description)
                .build();
    }
}
