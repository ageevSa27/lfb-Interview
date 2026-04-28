package com.example.deal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DealRequest {

    @NotBlank(message = "Title обязателен")
    private String title;

    private String description;

    @NotNull(message = "Amount обязателен")
    @Positive
    private BigDecimal amount;

    private String customerName;

    @Email(message = "Невалидный email")
    private String customerEmail;

    private String status;
}
