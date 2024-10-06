package com.character.classification.character_classification.controller;

import com.character.classification.character_classification.model.CharacterClassification;
import com.character.classification.character_classification.service.CharacterClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/characters")
public class CharacterClassificationController {

    @Autowired
    private CharacterClassificationService service;

    @PostMapping
    public ResponseEntity<CharacterClassification> createCharacter(@RequestBody CharacterClassification characterClassification){
        CharacterClassification savedCharacters = service.saveClass(characterClassification);
        return ResponseEntity.ok(savedCharacters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterClassification> getCharacterById(@PathVariable int id){
        return service.getClassById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllCharacters() {
        List<CharacterClassification> characterList = service.getAllClasses();
        List<Map<String, Object>> response = buildNestedStructure(characterList);
        return ResponseEntity.ok(response);
    }

    private List<Map<String, Object>> buildNestedStructure(List<CharacterClassification> characters) {
        Map<Integer, Map<String, Object>> idToCharacterMap = new HashMap<>();
        List<Map<String, Object>> rootCharacters = new ArrayList<>();

        for(CharacterClassification character : characters) {
            Map<String, Object> characterMap = new HashMap<>();
            characterMap.put("Name", character.getName());
            characterMap.put("Sub Classes", new ArrayList<>());
            idToCharacterMap.put(character.getId(), characterMap);
        }

        for(CharacterClassification character : characters){
            Map<String, Object> characterMap = idToCharacterMap.get(character.getId());
            if(character.getParentId() == 0){
                rootCharacters.add(characterMap);
            } else{
                Map<String, Object> parentCharacterMap = idToCharacterMap.get(character.getParentId());
                if(parentCharacterMap != null){
                    List<Map<String, Object>> subClasses = (List<Map<String, Object>>) parentCharacterMap.get("Sub Classes");
                    subClasses.add(characterMap);
                }
            }
        }
        return rootCharacters;
    }
}
