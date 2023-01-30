package com.emp.happiness.services;

import com.emp.happiness.dto.DynamicUIRequestDTO;
import com.emp.happiness.dto.DynamicUIResponseDTO;
import com.emp.happiness.dto.DynamicUiControlsResponseDTO;
import com.emp.happiness.entities.DynamicUiEntity;
import com.emp.happiness.repositories.DynamicUiRepository;
import lombok.AllArgsConstructor;
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
public class DynamicUiServiceImpl implements DynamicUiService {

    private final DynamicUiRepository dynamicUiRepository;

    @Override
    public DynamicUIResponseDTO save(DynamicUIRequestDTO dynamicUIRequestDTO) {
        DynamicUiEntity dynamicUiEntity = DynamicUIRequestDTO.toEntity(dynamicUIRequestDTO);
        return Optional.of(dynamicUiRepository.save(dynamicUiEntity))
                .map(DynamicUIResponseDTO::toDTO)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee Not Saved"));
    }

    @Override
    public List<DynamicUIResponseDTO> findAll() {
        var controlList = dynamicUiRepository.findAll();
        return controlList.stream().map(DynamicUIResponseDTO::toDTO).collect(Collectors.toList());
    }

    @Override
    public DynamicUIResponseDTO findById(Long id) {
        return dynamicUiRepository.findById(id).map(DynamicUIResponseDTO::toDTO)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Review Form Not Found"));
    }

    @Override
    public void delete(Long id) {
        dynamicUiRepository.findById(id).orElseThrow(() -> {
            log.debug(String.format("id Not found: %s", id));
            return new ResponseStatusException(HttpStatus.BAD_REQUEST,String.format("UI id : %s Not found", id));
        });
        dynamicUiRepository.deleteById(id);
    }
}
