package com.emp.happiness.dto;

import com.emp.happiness.dto.config.EmployeeHappinessQADTO;
import com.emp.happiness.entities.EmployeeHappinessReviewsEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeHappinessReviewsRequestDTO {

    private List<EmployeeHappinessQADTO> reviewData;
    private Long formId;
    private String formName;
    @JsonIgnore
    public static EmployeeHappinessReviewsEntity toEntity(EmployeeHappinessReviewsRequestDTO employeeHappinessReviewsRequestDTO) {

        Long count =  employeeHappinessReviewsRequestDTO.getReviewData().stream()
                .filter(f->f.getHappinessPer()!=1).count();

        Long sum = employeeHappinessReviewsRequestDTO.getReviewData().stream()
                .filter(f->f.getHappinessPer()!=1)
                .map(EmployeeHappinessQADTO::getHappinessPer)
                .mapToLong(Long::longValue).sum();

        Long happinessLevel = (sum*100)/(count*100);

        return EmployeeHappinessReviewsEntity.builder()
                .formId(employeeHappinessReviewsRequestDTO.getFormId())
                .formName(employeeHappinessReviewsRequestDTO.getFormName())
                .reviewData(employeeHappinessReviewsRequestDTO.getReviewData())
                .happinessLevel(happinessLevel)
                .build();
    }
}
