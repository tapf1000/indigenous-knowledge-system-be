package com.tapf.indigenousknowledgesystembe.controllers;

import com.tapf.indigenousknowledgesystembe.dto.CharacteristicEvaluationDto;
import com.tapf.indigenousknowledgesystembe.service.CharacteristicEvaluationHandlerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class CharacteristicEvaluationController {

    CharacteristicEvaluationHandlerService characteristicEvaluationHandlerService;
    public CharacteristicEvaluationController(CharacteristicEvaluationHandlerService characteristicEvaluationHandlerService){
        this.characteristicEvaluationHandlerService = characteristicEvaluationHandlerService;
    }

    @GetMapping("/char-eval/{cat-val}")
    public CharacteristicEvaluationDto getCharacteristicEvaluation(@PathVariable("cat-val") String catVal){
        return characteristicEvaluationHandlerService.getCharacteristicEvaluation(catVal);
    }
}
