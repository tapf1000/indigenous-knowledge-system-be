package com.tapf.indigenousknowledgesystembe.service;

import com.tapf.indigenousknowledgesystembe.dto.CategoryDto;
import com.tapf.indigenousknowledgesystembe.dto.CategoryValueDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryValueRequestHandlerService {

    List<CategoryValueDto> getCategoriesValues();

    CategoryValueDto getCategoryValue(String catValName);

    CategoryValueDto addCategoryValue(CategoryValueDto categoryValueDto);

    List<CategoryValueDto> getCategoryValuesByCategory(Long catValName);
}
