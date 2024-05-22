package com.tapf.indigenousknowledgesystembe.dto;

import com.tapf.indigenousknowledgesystembe.entities.Category;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryValueDto {
    String value;
    private CharacteristicEvaluationDto characteristicEvaluation;

    @Override
    public String toString(){
        return "{\nvalue: "+value+", \ncharacteristicEvaluation: "+characteristicEvaluation.toString()+"\n}";
    }
}
