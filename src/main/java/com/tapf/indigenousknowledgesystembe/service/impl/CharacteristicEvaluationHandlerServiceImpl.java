package com.tapf.indigenousknowledgesystembe.service.impl;

import com.tapf.indigenousknowledgesystembe.dto.CharacteristicEvaluationDto;
import com.tapf.indigenousknowledgesystembe.entities.CategoryValue;
import com.tapf.indigenousknowledgesystembe.repositories.CategoryValueRepository;
import com.tapf.indigenousknowledgesystembe.repositories.CharacteristicEvaluationRepository;
import com.tapf.indigenousknowledgesystembe.service.CharacteristicEvaluationHandlerService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.NoResourceFoundException;

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
    public CharacteristicEvaluationDto getCharacteristicEvaluation(String catVal) {
        CategoryValue categoryValue = categoryValueRepository.findCategoryValueByVal(catVal);
        if (categoryValue != null)
            return characteristicEvaluationToCharacteristicEvaluationDto(
                characteristicEvaluationRepository.findCharacteristicEvaluationByCategoryValue(categoryValue)
            );
        throw new RuntimeException("No resource for category value "+catVal);
    }
}
