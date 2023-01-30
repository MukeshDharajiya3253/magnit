package com.emp.happiness.dto;

import com.emp.happiness.constants.UIFieldType;
import com.emp.happiness.dto.config.ControlConfigDTO;
import com.emp.happiness.entities.DynamicUIControls;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DynamicUiControlsRequestDTO {

    private UIFieldType controlType;
    private String controlName;
    private String controlLabel;
    private ControlConfigDTO config;

    @JsonIgnore
    public static DynamicUIControls toEntity(DynamicUiControlsRequestDTO dynamicUiControlsRequestDTO) {
        return DynamicUIControls.builder()
                .controlType(dynamicUiControlsRequestDTO.getControlType())
                .controlName(dynamicUiControlsRequestDTO.getControlName())
                .controlLabel(dynamicUiControlsRequestDTO.getControlLabel())
                .config(dynamicUiControlsRequestDTO.getConfig())
                .build();
    }
}
