package com.tapf.indigenousknowledgesystembe.service.impl;

import com.tapf.indigenousknowledgesystembe.dto.CategoryDto;
import com.tapf.indigenousknowledgesystembe.entities.Category;
import com.tapf.indigenousknowledgesystembe.repositories.CategoryRepository;
import com.tapf.indigenousknowledgesystembe.repositories.CategoryValueRepository;
import com.tapf.indigenousknowledgesystembe.repositories.CharacteristicEvaluationRepository;
import com.tapf.indigenousknowledgesystembe.service.CategoryRequestHandlerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.tapf.indigenousknowledgesystembe.util.EntityToDtoMapper.categoryDtoToCategory;
import static com.tapf.indigenousknowledgesystembe.util.EntityToDtoMapper.categoryToCategoryDtoMapper;

@Service
public class CategoryRequestHandlerServiceImpl implements CategoryRequestHandlerService {

    CategoryRepository categoryRepository;
    CategoryValueRepository categoryValueRepository;
    CharacteristicEvaluationRepository characteristicEvaluationRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(CategoryRequestHandlerServiceImpl.class);
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
        var existingCat = categoryRepository.findCategoryByCatName(categoryDto.getCatName());
        Category category = categoryDtoToCategory(categoryDto);
        if (existingCat != null){
            category.setId(existingCat.getId());
        }
        return categoryToCategoryDtoMapper(categoryRepository.save(category));
    }
}
