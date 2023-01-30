package com.emp.happiness.dto;

import com.emp.happiness.dto.config.EmployeeHappinessQADTO;
import com.emp.happiness.entities.EmployeeHappinessReviewsEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeHappinessReviewsResponseDTO {

    private Long id;
    private List<EmployeeHappinessQADTO> reviewData;
    private String formName;
    private Long formId;
    private Date created;
    private Date updated;
    @JsonIgnore
    public static EmployeeHappinessReviewsResponseDTO toDTO(EmployeeHappinessReviewsEntity employeeHappinessReviewsEntity) {
        return EmployeeHappinessReviewsResponseDTO.builder()
                .id(employeeHappinessReviewsEntity.getId())
                .formId(employeeHappinessReviewsEntity.getFormId())
                .formName(employeeHappinessReviewsEntity.getFormName())
                .reviewData(employeeHappinessReviewsEntity.getReviewData())
                .created(employeeHappinessReviewsEntity.getCreated())
                .updated(employeeHappinessReviewsEntity.getUpdated())
                .build();
    }
}
