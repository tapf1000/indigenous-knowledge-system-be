package com.tapf.indigenousknowledgesystembe.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    String catName;
    List<CategoryValueDto> categoryValues;

    @Override
    public String toString(){
        return "{\ncatName: "+catName+", \ncategoryValues: ["+categoryValues.stream().map(c -> c.toString()).toList()+"\n]\n}";
    }
}
