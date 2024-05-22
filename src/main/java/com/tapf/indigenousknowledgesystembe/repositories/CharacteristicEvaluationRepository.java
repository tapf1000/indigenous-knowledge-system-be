package com.tapf.indigenousknowledgesystembe.repositories;

import com.tapf.indigenousknowledgesystembe.entities.Category;
import com.tapf.indigenousknowledgesystembe.entities.CategoryValue;
import com.tapf.indigenousknowledgesystembe.entities.CharacteristicEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacteristicEvaluationRepository extends JpaRepository<CharacteristicEvaluation, Long> {

    CharacteristicEvaluation findCharacteristicEvaluationByCategoryValue(CategoryValue categoryValue);

}