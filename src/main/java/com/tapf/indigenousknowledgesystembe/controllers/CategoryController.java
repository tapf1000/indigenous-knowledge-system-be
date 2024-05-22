package com.tapf.indigenousknowledgesystembe.controllers;

import com.tapf.indigenousknowledgesystembe.dto.CategoryDto;
import com.tapf.indigenousknowledgesystembe.service.CategoryRequestHandlerService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/api/v1/")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    private final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);
    CategoryRequestHandlerService categoryRequestHandlerService;
    public CategoryController(CategoryRequestHandlerService categoryRequestHandlerService){
        this.categoryRequestHandlerService = categoryRequestHandlerService;
    }

    @GetMapping("/categories")
    public List<CategoryDto> getCategories(){
        return categoryRequestHandlerService.getCategories();
    }

    @GetMapping("/categories/{cat}")
    public CategoryDto getCategory(@PathVariable String cat){
        return categoryRequestHandlerService.getCategory(cat);
    }

    @PostMapping("/add-category")
    public CategoryDto addCategory(@RequestBody CategoryDto categoryDto){
        return  categoryRequestHandlerService.addCategory(categoryDto);
    }



}
