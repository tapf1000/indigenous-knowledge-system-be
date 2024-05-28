package com.tapf.indigenousknowledgesystembe.controllers;

import com.tapf.indigenousknowledgesystembe.dto.CategoryValueDto;
import com.tapf.indigenousknowledgesystembe.service.CategoryValueRequestHandlerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class CategoryValueController {

    CategoryValueRequestHandlerService categoryValueRequestHandlerService;

    public CategoryValueController(CategoryValueRequestHandlerService categoryValueRequestHandlerService){
        this.categoryValueRequestHandlerService = categoryValueRequestHandlerService;
    }

    @GetMapping("/cat-vals")
    public List<CategoryValueDto> getCategoryValues(){
        return categoryValueRequestHandlerService.getAllCategoriesValues();
    }

    @GetMapping("/cat-val/{catValName}")
    public List<CategoryValueDto> getAllCategoryValues(@PathVariable("catValName") String catValName){
        return categoryValueRequestHandlerService.getCategoryValues(catValName);
    }
}
