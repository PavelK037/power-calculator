package com.example.power.dto;

import jakarta.validation.constraints.NotNull;

public record PowerRequest(
        @NotNull(message = "Base (x) is required")
        Double x,

        @NotNull(message = "Exponent (y) is required")
        Double y
) {
}