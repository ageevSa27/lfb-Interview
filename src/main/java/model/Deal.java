package model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Deal {

    private Long id;

    private String title;

    private String description;

    private BigDecimal amount;

    private String status; // NEW, IN_PROGRESS, COMPLETED, CANCELLED

    private String customerName;

    private String customerEmail;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
