package com.emp.happiness.services;

import com.emp.happiness.dto.EmployeeHappinessReviewsRequestDTO;
import com.emp.happiness.dto.EmployeeHappinessReviewsResponseDTO;
import com.emp.happiness.dto.config.DashBoardResponseDTO;
import com.emp.happiness.entities.EmployeeHappinessReviewsEntity;
import com.emp.happiness.repositories.EmployeeHappinessReviewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeHappinessReviewsServiceImpl implements EmployeeHappinessReviewsService {
    private final EmployeeHappinessReviewsRepository employeeHappinessReviewsRepository;
    @Override
    public EmployeeHappinessReviewsResponseDTO save(EmployeeHappinessReviewsRequestDTO employeeHappinessReviewsRequestDTO) {
        EmployeeHappinessReviewsEntity dynamicUiEntity = EmployeeHappinessReviewsRequestDTO.toEntity(employeeHappinessReviewsRequestDTO);
        return Optional.of(employeeHappinessReviewsRepository.save(dynamicUiEntity))
                .map(EmployeeHappinessReviewsResponseDTO::toDTO)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee Happiness Not Save Successfully"));
    }
    @Override
    public List<EmployeeHappinessReviewsResponseDTO> findAll() {
        var controlList = employeeHappinessReviewsRepository.findAll();
        return controlList.stream().map(EmployeeHappinessReviewsResponseDTO::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<DashBoardResponseDTO> viewDashBoard() {
        var controlList = employeeHappinessReviewsRepository.prepareDashboardData();
        return controlList;
    }
}
