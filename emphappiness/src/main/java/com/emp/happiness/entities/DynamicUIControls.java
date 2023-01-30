package com.emp.happiness.entities;

import com.emp.happiness.constants.UIFieldType;
import com.emp.happiness.dto.config.ControlConfigDTO;
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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "DynamicUIControls")
@Table(name = "dynamic_ui_controls")
@TypeDef(name = "json",
        typeClass = JsonStringType.class)
@Where(clause = "deleted <> '1'")
@Builder
@DynamicInsert
@DynamicUpdate
@ToString
public class DynamicUIControls  extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "control_type", columnDefinition = "VARCHAR(32)")
    private UIFieldType controlType;

    @Column(name = "control_name", columnDefinition = "VARCHAR(64)")
    private String controlName;

    @Column(name = "control_label", columnDefinition = "VARCHAR(64)")
    private String controlLabel;

    @Type(type = "json")
    @Column(name = "config", columnDefinition = "json")
    private ControlConfigDTO config ;

}
