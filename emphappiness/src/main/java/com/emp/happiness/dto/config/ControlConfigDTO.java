package com.emp.happiness.dto.config;

import lombok.Data;
import java.util.List;

@Data
public class ControlConfigDTO {
    private List<ControlValue> controlValue;
    private boolean required;
    private String cssClass;
}
