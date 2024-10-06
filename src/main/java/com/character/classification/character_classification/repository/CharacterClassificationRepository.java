package com.character.classification.character_classification.repository;

import com.character.classification.character_classification.model.CharacterClassification;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CharacterClassificationRepository extends JpaRepository<CharacterClassification, Integer> {
}
