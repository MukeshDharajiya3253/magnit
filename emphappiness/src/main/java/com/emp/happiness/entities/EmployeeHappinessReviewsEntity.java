package com.emp.happiness.entities;

import com.emp.happiness.dto.config.EmployeeHappinessQADTO;
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
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "EmployeeHappinessReviewsEntity")
@Table(name = "employee_happiness_reviews")
@TypeDef(name = "json",
        typeClass = JsonStringType.class)
@Where(clause = "deleted <> '1'")
@Builder
@DynamicInsert
@DynamicUpdate
@ToString
public class EmployeeHappinessReviewsEntity extends BaseEntity {

    @Type(type = "json")
    @Column(name = "review_data", columnDefinition = "json")
    private List<EmployeeHappinessQADTO> reviewData ;

    @Column(name="formId")
    private Long formId;

    @Column(name="form_name")
    private String formName;

    @Column(name="happiness_level")
    private Long happinessLevel;

}
