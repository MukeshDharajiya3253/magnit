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
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DynamicUIResponseDTO {

    private Long id;
    private String formName;
    private Date created;
    private Date updated;
    private List<DynamicUiControlsConfig> controlsConfig;

    @JsonIgnore
    public static DynamicUIResponseDTO toDTO(DynamicUiEntity dynamicUiEntity) {
        return DynamicUIResponseDTO.builder()
                .id(dynamicUiEntity.getId())
                .formName(dynamicUiEntity.getFormName())
                .controlsConfig(dynamicUiEntity.getControlsConfig())
                .created(dynamicUiEntity.getCreated())
                .updated(dynamicUiEntity.getUpdated())
                .build();
    }
}
