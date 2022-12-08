package com.krzysztofpapiernik.swapi.model;

import com.krzysztofpapiernik.swapi.controller.dto.GetCharacterDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CharacterTest {

    @Test
    void itShouldReturnCharacterWithId() {
        //Given
        var character = Character.builder()
                .name("TEST")
                .height(180)
                .mass(200)
                .build();
        //When
        var result = character.withId(1L);
        //Then
        assertThat(result.id).isEqualTo(1L);
    }

    @Test
    void itShouldReturnGetCharacterDto() {
        //Given
        var expected = new GetCharacterDto(1L, "TEST", 180, 200);
        var character = new Character(1L, "TEST", 180, 200);
        //When
        var result = character.getCharacterDto();
        //Then
        assertThat(result).isEqualTo(expected);
    }
}