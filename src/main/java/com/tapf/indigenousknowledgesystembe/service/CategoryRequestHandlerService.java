package com.tapf.indigenousknowledgesystembe.service;

import com.tapf.indigenousknowledgesystembe.dto.CategoryDto;
import com.tapf.indigenousknowledgesystembe.dto.CategoryValueDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryRequestHandlerService {

    List<CategoryDto> getCategories();

    CategoryDto getCategory(String catName);

    CategoryDto addCategory(CategoryDto categoryDto);
}
