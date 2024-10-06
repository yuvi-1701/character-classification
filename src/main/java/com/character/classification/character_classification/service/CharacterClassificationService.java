package com.character.classification.character_classification.service;

import com.character.classification.character_classification.model.CharacterClassification;
import com.character.classification.character_classification.repository.CharacterClassificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CharacterClassificationService {

    @Autowired
    private CharacterClassificationRepository repository;

    public CharacterClassification saveClass(CharacterClassification characterClassification){
        return repository.save(characterClassification);
    }

    public Optional<CharacterClassification> getClassById(int id){
        return repository.findById(id);
    }

    public List<CharacterClassification> getAllClasses(){
        return repository.findAll();
    }
}
