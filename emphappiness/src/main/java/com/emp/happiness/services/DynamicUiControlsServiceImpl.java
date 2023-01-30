package com.emp.happiness.services;

import com.emp.happiness.dto.DynamicUiControlsRequestDTO;
import com.emp.happiness.dto.DynamicUiControlsResponseDTO;
import com.emp.happiness.entities.DynamicUIControls;
import com.emp.happiness.repositories.DynamicUIControlsRepository;
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
public class DynamicUiControlsServiceImpl implements DynamicUiControlsService {
    private final DynamicUIControlsRepository dynamicUIControlsRepository;

    @Override
    public DynamicUiControlsResponseDTO save(DynamicUiControlsRequestDTO dynamicUiControlsRequestDTO) {
        DynamicUIControls dynamicUIControls = DynamicUiControlsRequestDTO.toEntity(dynamicUiControlsRequestDTO);
        return Optional.of(dynamicUIControlsRepository.save(dynamicUIControls))
                .map(DynamicUiControlsResponseDTO::toDTO)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Controls Not Saved"));
    }

    @Override
    public List<DynamicUiControlsResponseDTO> findAll() {
        var controlList = dynamicUIControlsRepository.findAll();
        return controlList.stream().map(DynamicUiControlsResponseDTO::toDTO).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        dynamicUIControlsRepository.findById(id).orElseThrow(() -> {
            log.debug(String.format("id Not found: %s", id));
            return new ResponseStatusException(HttpStatus.BAD_REQUEST,String.format("Control id : %s Not found", id));
        });
        dynamicUIControlsRepository.deleteById(id);
    }
}
