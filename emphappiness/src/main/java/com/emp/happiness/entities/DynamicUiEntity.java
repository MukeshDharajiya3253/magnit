package com.emp.happiness.entities;

import com.emp.happiness.dto.config.DynamicUiControlsConfig;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.Where;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "DynamicUiEntity")
@Table(name = "dynamic_ui")
@TypeDef(name = "json",
        typeClass = JsonStringType.class)
@DynamicInsert
@DynamicUpdate
@ToString
@Where(clause = "deleted <> '1'")
@Builder
public class DynamicUiEntity  extends BaseEntity {

    @Column(name = "form_name", columnDefinition = "VARCHAR(32)")
    private String formName;

    @Type(type = "json")
    @Column(name = "controls_config", columnDefinition = "json")
    private List<DynamicUiControlsConfig> controlsConfig;
}
