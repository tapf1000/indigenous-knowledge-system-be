package com.tapf.indigenousknowledgesystembe.service;

import com.tapf.indigenousknowledgesystembe.dto.CategoryValueDto;

import java.util.List;

public interface CategoryValueRequestHandlerService {

    List<CategoryValueDto> getAllCategoriesValues();

    List<CategoryValueDto> getCategoryValues(String catValName);

    CategoryValueDto addCategoryValue(CategoryValueDto categoryValueDto);

}
