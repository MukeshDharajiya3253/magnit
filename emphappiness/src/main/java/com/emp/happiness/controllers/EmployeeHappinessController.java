package com.emp.happiness.controllers;

import com.emp.happiness.dto.DynamicUiControlsResponseDTO;
import com.emp.happiness.dto.EmployeeHappinessReviewsRequestDTO;
import com.emp.happiness.dto.EmployeeHappinessReviewsResponseDTO;
import com.emp.happiness.dto.config.DashBoardResponseDTO;
import com.emp.happiness.services.EmployeeHappinessReviewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("happiness-review")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeHappinessController {
    private final EmployeeHappinessReviewsService happinessReviewsService;

    @PostMapping
    public ResponseEntity<EmployeeHappinessReviewsResponseDTO> save(@RequestBody @Validated EmployeeHappinessReviewsRequestDTO employeeHappinessReviewsRequestDTO) {
        return ResponseEntity.ok(happinessReviewsService.save(employeeHappinessReviewsRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeHappinessReviewsResponseDTO>> findAll() {
        return ResponseEntity.ok(happinessReviewsService.findAll());
    }
    @GetMapping("dashboard")
    public ResponseEntity<List<DashBoardResponseDTO>> dashboard() {
        return ResponseEntity.ok(happinessReviewsService.viewDashBoard());
    }
}
