package com.emp.happiness.controllers;

import com.emp.happiness.dto.DynamicUIRequestDTO;
import com.emp.happiness.dto.DynamicUIResponseDTO;
import com.emp.happiness.dto.DynamicUiControlsResponseDTO;
import com.emp.happiness.services.DynamicUiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
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
@RequestMapping("dynamic-ui")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class DynamicUIController {
    private final DynamicUiService dynamicUiService;

    @PostMapping
    public ResponseEntity<DynamicUIResponseDTO> save(@RequestBody @Validated DynamicUIRequestDTO dynamicUIRequestDTO) {
        return ResponseEntity.ok(dynamicUiService.save(dynamicUIRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<DynamicUIResponseDTO>> findAll() {
        return ResponseEntity.ok(dynamicUiService.findAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<DynamicUIResponseDTO> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(dynamicUiService.findById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        dynamicUiService.delete(id);
        return ResponseEntity.ok().build();
    }

}
