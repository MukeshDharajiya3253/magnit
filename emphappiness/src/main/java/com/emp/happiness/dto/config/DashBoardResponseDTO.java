package com.emp.happiness.dto.config;

import lombok.Data;

@Data
public class DashBoardResponseDTO {
    private String formName;
    private Double average;

    public DashBoardResponseDTO(String formName,Double average){
        this.formName=formName;
        this.average=average;
    }
}
