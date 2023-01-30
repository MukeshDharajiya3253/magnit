package com.emp.happiness.services;

import com.emp.happiness.dto.DynamicUiControlsRequestDTO;
import com.emp.happiness.dto.DynamicUiControlsResponseDTO;

import java.util.List;

public interface DynamicUiControlsService {
    DynamicUiControlsResponseDTO save(DynamicUiControlsRequestDTO dynamicUiControlsRequestDTO);
    List<DynamicUiControlsResponseDTO> findAll();

    void delete(Long id);
}
