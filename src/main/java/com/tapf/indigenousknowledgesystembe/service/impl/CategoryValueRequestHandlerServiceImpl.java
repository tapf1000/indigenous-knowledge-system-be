package com.tapf.indigenousknowledgesystembe.service.impl;

import com.tapf.indigenousknowledgesystembe.dto.CategoryValueDto;
import com.tapf.indigenousknowledgesystembe.entities.Category;
import com.tapf.indigenousknowledgesystembe.entities.CategoryValue;
import com.tapf.indigenousknowledgesystembe.repositories.CategoryRepository;
import com.tapf.indigenousknowledgesystembe.repositories.CategoryValueRepository;
import com.tapf.indigenousknowledgesystembe.service.CategoryValueRequestHandlerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.tapf.indigenousknowledgesystembe.util.EntityToDtoMapper.*;
import static com.tapf.indigenousknowledgesystembe.util.EntityToDtoMapper.categoryValueToCategoryDtoMapper;

@Service
public class CategoryValueRequestHandlerServiceImpl implements CategoryValueRequestHandlerService {

    CategoryValueRepository categoryValueRepository;
    CategoryRepository categoryRepository;
    public CategoryValueRequestHandlerServiceImpl(
            CategoryValueRepository categoryValueRepository,
            CategoryRepository categoryRepository
    ){
        this.categoryValueRepository = categoryValueRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryValueDto> getAllCategoriesValues() {
        return categoryValueRepository.findAll()
                .stream()
                .map(c -> categoryValuesToCategoryValuesDto(c))
                .toList();
    }

    @Override
    public List<CategoryValueDto> getCategoryValues(String catValName) {
        var cat = categoryRepository.findCategoryByCatName(catValName);
        if (Objects.nonNull(cat)){
           return categoryValueRepository.findCategoryValueByCategory(cat)
                    .stream()
                    .map(c -> categoryValuesToCategoryValuesDto(c))
                    .toList();
        }
        else
            return null;
    }

    @Override
    public CategoryValueDto addCategoryValue(CategoryValueDto categoryValueDto) {
        Category category = categoryRepository.findCategoryByCatName(categoryValueDto.getValue());
        CategoryValue categoryValue;
        if (category != null)
            categoryValue = categoryValueDtoToCategoryValue(categoryValueDto, category);
        else return null;
        return categoryValueToCategoryDtoMapper(categoryValueRepository.save(categoryValue));
    }
}