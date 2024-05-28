package com.tapf.indigenousknowledgesystembe.service.impl;

import com.tapf.indigenousknowledgesystembe.dto.CategoryDto;
import com.tapf.indigenousknowledgesystembe.entities.Category;
import com.tapf.indigenousknowledgesystembe.entities.CategoryValue;
import com.tapf.indigenousknowledgesystembe.repositories.CategoryRepository;
import com.tapf.indigenousknowledgesystembe.repositories.CategoryValueRepository;
import com.tapf.indigenousknowledgesystembe.repositories.CharacteristicEvaluationRepository;
import com.tapf.indigenousknowledgesystembe.service.CategoryRequestHandlerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.tapf.indigenousknowledgesystembe.util.EntityToDtoMapper.*;
import static com.tapf.indigenousknowledgesystembe.util.EntityToDtoMapper.categoryValueDtoToCategoryValue;

@Slf4j
@Service
public class CategoryRequestHandlerServiceImpl implements CategoryRequestHandlerService {

    CategoryRepository categoryRepository;
    CategoryValueRepository categoryValueRepository;
    CharacteristicEvaluationRepository characteristicEvaluationRepository;

    public CategoryRequestHandlerServiceImpl(
            CategoryRepository categoryRepository,
            CategoryValueRepository categoryValueRepository,
            CharacteristicEvaluationRepository characteristicEvaluationRepository
    ){
        this.categoryRepository = categoryRepository;
        this.categoryValueRepository = categoryValueRepository;
        this.characteristicEvaluationRepository = characteristicEvaluationRepository;
    }

    @Override
    public List<CategoryDto> getCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(c -> categoryToCategoryDtoMapper(c))
                .toList();
    }

    @Override
    public CategoryDto getCategory(String catName) {
        return categoryToCategoryDtoMapper(categoryRepository.findCategoryByCatName(catName));
    }

    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        log.info("categoryDto name: {}", categoryDto.toString());
        var existingCat = categoryRepository.findCategoryByCatName(categoryDto.getCatName());
        Category category = categoryDtoToCategory(categoryDto);
        if (existingCat != null){
            category.setId(existingCat.getId());
        }
        var savedCategory = categoryRepository.save(category);
        addCategoryTransientEntities(savedCategory);
        return categoryToCategoryDtoMapper(savedCategory);
    }

    private void addCategoryTransientEntities(Category category){
        category.getCategoryValues().forEach(
                cv -> {
                    var ce = characteristicEvaluationRepository.save(cv.getCharacteristicEvaluation());
                    cv.setCharacteristicEvaluation(ce);
                    categoryValueRepository.save(cv);
                }
        );
    }

    private void addCharacteristicEvaluation(){

    }
}
