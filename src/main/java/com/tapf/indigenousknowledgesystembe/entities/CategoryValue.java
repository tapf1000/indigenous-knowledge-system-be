package com.tapf.indigenousknowledgesystembe.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CategoryValue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String val;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "characteristic_evaluation_id")
    private CharacteristicEvaluation characteristicEvaluation;
}
