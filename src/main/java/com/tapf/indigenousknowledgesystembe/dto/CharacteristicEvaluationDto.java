package com.tapf.indigenousknowledgesystembe.dto;

import com.tapf.indigenousknowledgesystembe.entities.CategoryValue;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacteristicEvaluationDto {

    String characteristic;
    String evaluation;
    @Override
    public String toString(){
        return "{\ncharacteristic: "+characteristic+", \n evaluation: "+evaluation+"\n}";
    }
}
