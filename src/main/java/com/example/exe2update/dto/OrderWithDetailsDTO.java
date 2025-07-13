package com.example.exe2update.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderWithDetailsDTO {
    private Integer orderId;
    private String fullName;
    private BigDecimal totalAmount;
    private LocalDateTime orderDate;
    private List<String> productNames;
}
