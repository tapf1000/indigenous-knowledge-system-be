package com.tapf.indigenousknowledgesystembe.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CharacteristicEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToOne(mappedBy = "characteristicEvaluation")
    private CategoryValue categoryValue;

    String characteristic;

    String evaluation;
}
