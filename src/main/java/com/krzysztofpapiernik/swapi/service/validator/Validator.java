package com.krzysztofpapiernik.swapi.service.validator;

import com.krzysztofpapiernik.swapi.model.Character;

public interface Validator{

    static void validateId(Long id){
        if(id == null){
            throw new ValidationException("id is null");
        }
    }

    static void validateSearchedExpression(String expression){
        if(expression == null){
            throw new ValidationException("expression is null");
        }

        if(expression.isEmpty()){
            throw new ValidationException("expression is empty string");
        }
    }

    static boolean validateCharacterHeight(Character character, Integer minimumHeight){
        return character.getHeight() >= minimumHeight;
    }
}
