package com.example.power.dto;

public record PowerResponse(
        double result,
        String message
) {
    public static PowerResponse success(double result) {
        return new PowerResponse(result, "Success");
    }
}