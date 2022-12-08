package com.krzysztofpapiernik.swapi.controller;

import com.krzysztofpapiernik.swapi.controller.dto.GetCharacterDto;
import com.krzysztofpapiernik.swapi.controller.dto.ResponseDto;
import com.krzysztofpapiernik.swapi.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;

    @PostMapping("/{characterId}")
    public void importElevator(@PathVariable("characterId") Long id){
        characterService.importCharacter(id);
    }

    @GetMapping("/{characterId}")
    public ResponseDto<GetCharacterDto> getCharacter(@PathVariable("characterId") Long id){
        return new ResponseDto<>(characterService.getCharacter(id));
    }

    @GetMapping
    public ResponseDto<List<GetCharacterDto>> findCharactersByName(@RequestParam("name") String searchedValue){
        return new ResponseDto<>(characterService.findCharactersByName(searchedValue));
    }


}
