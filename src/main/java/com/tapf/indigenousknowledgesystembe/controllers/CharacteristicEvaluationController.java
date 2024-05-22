package com.tapf.indigenousknowledgesystembe.controllers;

import com.tapf.indigenousknowledgesystembe.dto.CharacteristicEvaluationDto;
import com.tapf.indigenousknowledgesystembe.service.CharacteristicEvaluationHandlerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/v1")
@RestController
public class CharacteristicEvaluationController {

    CharacteristicEvaluationHandlerService characteristicEvaluationHandlerService;
    public CharacteristicEvaluationController(){

    }

    @GetMapping("/char-eval/{cat-val}")
    public CharacteristicEvaluationDto getCharacteristicEvaluation(@Param("cat-val") Long catVal){
        return characteristicEvaluationHandlerService.getCharacteristicEvaluation(catVal);
    }
}
