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
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DynamicUiControlsResponseDTO {

    private Long id;
    private UIFieldType controlType;
    private String controlName;
    private String controlLabel;
    private ControlConfigDTO config;
    private Date created;
    private Date updated;

    @JsonIgnore
    public static DynamicUiControlsResponseDTO toDTO(DynamicUIControls dynamicUIControls) {
        return DynamicUiControlsResponseDTO.builder()
                .id(dynamicUIControls.getId())
                .controlType(dynamicUIControls.getControlType())
                .controlName(dynamicUIControls.getControlName())
                .controlLabel(dynamicUIControls.getControlLabel())
                .config(dynamicUIControls.getConfig())
                .created(dynamicUIControls.getCreated())
                .updated(dynamicUIControls.getUpdated())
                .build();
    }
}
