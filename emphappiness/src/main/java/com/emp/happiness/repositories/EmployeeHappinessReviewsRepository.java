package com.emp.happiness.repositories;

import com.emp.happiness.dto.config.DashBoardResponseDTO;
import com.emp.happiness.entities.EmployeeHappinessReviewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmployeeHappinessReviewsRepository extends JpaRepository<EmployeeHappinessReviewsEntity, Long> {

    @Query("SELECT new com.emp.happiness.dto.config.DashBoardResponseDTO(emp.formName,avg(emp.happinessLevel) as average)" +
            " FROM EmployeeHappinessReviewsEntity as emp" +
            " GROUP BY emp.formName")
    List<DashBoardResponseDTO> prepareDashboardData();
}