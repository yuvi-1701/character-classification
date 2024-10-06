package com.character.classification.character_classification.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "character_classification")
@Data
public class CharacterClassification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int parentId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String color;

}
