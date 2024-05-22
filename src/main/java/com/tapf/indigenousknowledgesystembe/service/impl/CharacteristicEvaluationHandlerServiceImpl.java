package com.tapf.indigenousknowledgesystembe.service.impl;

import com.tapf.indigenousknowledgesystembe.dto.CharacteristicEvaluationDto;
import com.tapf.indigenousknowledgesystembe.entities.CategoryValue;
import com.tapf.indigenousknowledgesystembe.repositories.CategoryValueRepository;
import com.tapf.indigenousknowledgesystembe.repositories.CharacteristicEvaluationRepository;
import com.tapf.indigenousknowledgesystembe.service.CharacteristicEvaluationHandlerService;
import org.springframework.stereotype.Service;

import static com.tapf.indigenousknowledgesystembe.util.EntityToDtoMapper.characteristicEvaluationToCharacteristicEvaluationDto;

@Service
public class CharacteristicEvaluationHandlerServiceImpl implements CharacteristicEvaluationHandlerService {

    CharacteristicEvaluationRepository characteristicEvaluationRepository;
    CategoryValueRepository categoryValueRepository;

    public CharacteristicEvaluationHandlerServiceImpl(
            CharacteristicEvaluationRepository characteristicEvaluationRepository,
            CategoryValueRepository categoryValueRepository
    ){
        this.characteristicEvaluationRepository = characteristicEvaluationRepository;
        this.categoryValueRepository = categoryValueRepository;
    }

    @Override
    public CharacteristicEvaluationDto getCharacteristicEvaluation(Long catVal) {
        CategoryValue categoryValue = categoryValueRepository.findById(catVal).get();
        return characteristicEvaluationToCharacteristicEvaluationDto(
                characteristicEvaluationRepository.findCharacteristicEvaluationByCategoryValue(categoryValue)
        );
    }
}
