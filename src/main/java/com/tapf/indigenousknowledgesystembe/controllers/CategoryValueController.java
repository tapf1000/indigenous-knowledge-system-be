package com.tapf.indigenousknowledgesystembe.controllers;

import com.tapf.indigenousknowledgesystembe.dto.CategoryValueDto;
import com.tapf.indigenousknowledgesystembe.service.CategoryValueRequestHandlerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/api/v1")
@RestController
public class CategoryValueController {

    CategoryValueRequestHandlerService categoryValueRequestHandlerService;

    public CategoryValueController(CategoryValueRequestHandlerService categoryValueRequestHandlerService){
        this.categoryValueRequestHandlerService = categoryValueRequestHandlerService;
    }

    @GetMapping("/cat-val/{catValName}")
    public CategoryValueDto getCategoryValue(@Param("catValName") String catValName){
        return categoryValueRequestHandlerService.getCategoryValue(catValName);
    }

    @GetMapping("/cat-val/{cat}")
    public List<CategoryValueDto> getCategoryValuesByCategory(@Param("cat") Long cat){
        return categoryValueRequestHandlerService.getCategoryValuesByCategory(cat);
    }
}
