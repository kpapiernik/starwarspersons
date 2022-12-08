package com.krzysztofpapiernik.swapi.repository;

import com.krzysztofpapiernik.swapi.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
    Optional<Character> findCharactersByIdAndHeightGreaterThanEqual(Long id, Integer minHeight);
    List<Character> findCharactersByNameContainingIgnoreCaseAndHeightGreaterThanEqual(String expression, Integer minHeight);
}
