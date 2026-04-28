package com.example.deal.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class DealResponse {
    private Long id;
    private String title;
    private String description;
    private BigDecimal amount;
    private DealStatus status;
    private String customerName;
    private String customerEmail;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
