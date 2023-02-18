package com.example.Loahub.service;
import com.example.Loahub.controller.ColosseumsApiClient;
import com.example.Loahub.model.network.response.ColosseumResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Service
public class ColosseumService{
    private final ColosseumsApiClient colosseumsApiClient;

    @Transactional(readOnly = true)
    public ColosseumResponseDto findByCharacterName(String characterName){
        return colosseumsApiClient.requestColosseums(characterName);
    }
}