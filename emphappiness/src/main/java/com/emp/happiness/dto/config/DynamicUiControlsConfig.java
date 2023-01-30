package com.emp.happiness.dto.config;

import com.emp.happiness.constants.UIFieldType;
import lombok.Data;

@Data
public class DynamicUiControlsConfig {
    private UIFieldType controlType;
    private String controlName;
    private String controlLabel;
    private String question;
    private ControlConfigDTO config ;
}
