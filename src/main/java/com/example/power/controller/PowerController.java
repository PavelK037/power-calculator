package com.example.power.controller;

import com.example.power.dto.PowerRequest;
import com.example.power.dto.PowerResponse;
import com.example.power.service.PowerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PowerController {

    private final PowerService powerService;

    public PowerController(PowerService powerService) {
        this.powerService = powerService;
    }

    @PostMapping("/power")
    public ResponseEntity<PowerResponse> calculatePower(
            @Valid @RequestBody PowerRequest request) {

        PowerResponse response = powerService.calculatePower(request);
        return ResponseEntity.ok(response);
    }
}