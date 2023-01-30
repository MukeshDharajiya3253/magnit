package com.emp.happiness.services;

import com.emp.happiness.dto.DynamicUIRequestDTO;
import com.emp.happiness.dto.DynamicUIResponseDTO;

import java.util.List;

public interface DynamicUiService {
    DynamicUIResponseDTO save(DynamicUIRequestDTO dynamicUIRequestDTO);
    List<DynamicUIResponseDTO> findAll();

    DynamicUIResponseDTO findById(Long id);

    void delete(Long id);
}
