package com.example.power.service;

import com.example.power.dto.PowerRequest;
import com.example.power.dto.PowerResponse;
import org.springframework.stereotype.Service;

@Service
public class PowerService {

    public PowerResponse calculatePower(PowerRequest request) {
        double result = Math.pow(request.x(), request.y());
        return PowerResponse.success(result);
    }
}