package com.tapf.indigenousknowledgesystembe.util;

import com.tapf.indigenousknowledgesystembe.dto.CategoryDto;
import com.tapf.indigenousknowledgesystembe.dto.CategoryValueDto;
import com.tapf.indigenousknowledgesystembe.dto.CharacteristicEvaluationDto;
import com.tapf.indigenousknowledgesystembe.entities.Category;
import com.tapf.indigenousknowledgesystembe.entities.CategoryValue;
import com.tapf.indigenousknowledgesystembe.entities.CharacteristicEvaluation;

import java.util.List;

public class EntityToDtoMapper {

    public static CategoryDto categoryToCategoryDtoMapper(Category category){
        return CategoryDto.builder()
                .catName(category.getCatName())
                .build();
    }

    public static Category categoryDtoToCategory(CategoryDto categoryDto){
        Category category = new Category();
        List<CategoryValue> categoryValues = categoryDto
                .getCategoryValues()
                .stream()
                .map(c -> categoryValueDtoToCategoryValue(c, category)).toList();
        category.setCatName(categoryDto.getCatName());
        category.setCategoryValues(categoryValues);
        return category;
    }

    public static CategoryValueDto categoryValuesToCategoryValuesDto(CategoryValue categoryValues){
        return CategoryValueDto.builder()
                .value(categoryValues.getVal())
                .build();
    }

    public static CategoryValue categoryValueDtoToCategoryValue(CategoryValueDto categoryValueDto, Category category) {
         CategoryValue categoryValue = new CategoryValue();
         categoryValue.setVal(categoryValueDto.getValue());
         categoryValue.setCategory(category);
        categoryValue.setCharacteristicEvaluation(
                characteristicEvaluationDtoToCharacteristicEvaluation(categoryValueDto.getCharacteristicEvaluation())
        );
         return categoryValue;
    }

    public static CategoryValueDto categoryValueToCategoryDtoMapper(CategoryValue categoryValue){
        return CategoryValueDto.builder()
                .value(categoryValue.getVal())
                .build();
    }

    public static CharacteristicEvaluation characteristicEvaluationDtoToCharacteristicEvaluation(CharacteristicEvaluationDto characteristicEvaluationDto){
        CharacteristicEvaluation characteristicEvaluation = new CharacteristicEvaluation();
        characteristicEvaluation.setCharacteristic(characteristicEvaluationDto.getCharacteristic());
        characteristicEvaluation.setEvaluation(characteristicEvaluationDto.getEvaluation());
        return characteristicEvaluation;
    }

    public static CharacteristicEvaluationDto characteristicEvaluationToCharacteristicEvaluationDto(
            CharacteristicEvaluation characteristicEvaluation
    ){
        return CharacteristicEvaluationDto.builder()
                .characteristic(characteristicEvaluation.getCharacteristic())
                .evaluation(characteristicEvaluation.getEvaluation())
                .build();
    }
}
