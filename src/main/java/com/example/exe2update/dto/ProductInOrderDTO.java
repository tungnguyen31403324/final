// ProductInOrderDTO.java
package com.example.exe2update.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductInOrderDTO {
    private String productName;
    private BigDecimal price;
    private Integer quantity;
}
