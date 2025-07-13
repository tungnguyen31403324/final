// OrderWithDetailsDTO.java
package com.example.exe2update.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderWithDetailsDTO {
    private Integer orderId;
    private String fullName;
    private BigDecimal totalAmount;
    private LocalDateTime orderDate;
    private List<ProductInOrderDTO> products; // dùng DTO mới
}
