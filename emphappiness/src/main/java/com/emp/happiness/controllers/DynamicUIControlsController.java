package com.emp.happiness.controllers;

import com.emp.happiness.dto.DynamicUiControlsRequestDTO;
import com.emp.happiness.dto.DynamicUiControlsResponseDTO;
import com.emp.happiness.services.DynamicUiControlsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("controls")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class DynamicUIControlsController {
    private final DynamicUiControlsService dynamicUiControlsService;

    @PostMapping
    public ResponseEntity<DynamicUiControlsResponseDTO> save(@RequestBody @Validated DynamicUiControlsRequestDTO dynamicUiControlsRequestDTO) {
        return ResponseEntity.ok(dynamicUiControlsService.save(dynamicUiControlsRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<DynamicUiControlsResponseDTO>> findAll() {
        return ResponseEntity.ok(dynamicUiControlsService.findAll());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        dynamicUiControlsService.delete(id);
        return ResponseEntity.ok().build();
    }
}
