package com.example.Loahub.controller.api;

import com.example.Loahub.model.network.response.ColosseumResponseDto;
import com.example.Loahub.service.ColosseumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequiredArgsConstructor
public class ColosseumApiController {
    private final ColosseumService colosseumService;

    @GetMapping("/api/loahub/colosseums/{characterName}")
    public ColosseumResponseDto get(@PathVariable String characterName){
        return colosseumService.findByCharacterName(characterName);
    }
}
