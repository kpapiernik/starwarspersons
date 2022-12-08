package com.krzysztofpapiernik.swapi.service;

import com.krzysztofpapiernik.swapi.controller.dto.GetCharacterDto;
import com.krzysztofpapiernik.swapi.exception.CharacterServiceException;
import com.krzysztofpapiernik.swapi.model.Character;
import com.krzysztofpapiernik.swapi.repository.CharacterRepository;
import com.krzysztofpapiernik.swapi.service.validator.Validator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CharacterService {

    private final WebClient webClient;
    private final CharacterRepository characterRepository;

    @Value("${characterService.minimumHeight}")
    private Integer MINIMUM_HEIGHT;

    public void importCharacter(Long id){
        Validator.validateId(id);

        var responseCharacter = webClient
                .get()
                .uri("people/%d".formatted(id))
                .retrieve()
                .bodyToMono(Character.class)
                .onErrorResume(WebClientResponseException.class, Mono::error)
                .share()
                .block();

        var characterWithId = responseCharacter.withId(id);

        characterRepository.save(characterWithId);
    }

    public GetCharacterDto getCharacter(Long id){
        Validator.validateId(id);
        return characterRepository
                .findCharactersByIdAndHeightGreaterThanEqual(id, MINIMUM_HEIGHT)
                .map(Character::getCharacterDto)
                .orElseThrow(() -> new CharacterServiceException("Character does not exist"));
    }

    public List<GetCharacterDto> findCharactersByName(String searchedValue){
        Validator.validateSearchedExpression(searchedValue);
        return characterRepository
                .findCharactersByNameContainingIgnoreCaseAndHeightGreaterThanEqual(searchedValue, MINIMUM_HEIGHT)
                .stream()
                .map(Character::getCharacterDto)
                .toList();
    }


}
