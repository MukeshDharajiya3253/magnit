package com.emp.happiness.services;

import com.emp.happiness.dto.DynamicUiControlsRequestDTO;
import com.emp.happiness.dto.EmployeeHappinessReviewsRequestDTO;
import com.emp.happiness.dto.EmployeeHappinessReviewsResponseDTO;
import com.emp.happiness.dto.config.DashBoardResponseDTO;

import java.util.List;

public interface EmployeeHappinessReviewsService {
    EmployeeHappinessReviewsResponseDTO save(EmployeeHappinessReviewsRequestDTO employeeHappinessReviewsRequestDTO);

    List<EmployeeHappinessReviewsResponseDTO> findAll();

    List<DashBoardResponseDTO> viewDashBoard();
}
