package com.emp.happiness.dto;

import com.emp.happiness.dto.config.DynamicUiControlsConfig;
import com.emp.happiness.entities.DynamicUIControls;
import com.emp.happiness.entities.DynamicUiEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DynamicUIRequestDTO {

    @Size(max = 255)
    @NotBlank
    @NotEmpty(message="Please enter ruff status")
    private String formName;

    @NotNull
    private List<DynamicUiControlsConfig> controlsConfig;
    @JsonIgnore
    public static DynamicUiEntity toEntity(DynamicUIRequestDTO dynamicUIRequestDTO) {
    return DynamicUiEntity.builder()
            .formName(dynamicUIRequestDTO.getFormName())
            .controlsConfig(dynamicUIRequestDTO.getControlsConfig())
            .build();
    }
}
