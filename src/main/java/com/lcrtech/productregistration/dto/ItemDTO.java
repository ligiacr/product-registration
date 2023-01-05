package com.lcrtech.productregistration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    private Long id;
    private BigDecimal subTotal;
    private Integer quantity;
    private Long productId;
    private String productName;
}
