package com.lcrtech.productregistration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    private Integer id;
    private BigDecimal subTotal;
    private Integer quantity;
    private Integer productId;
    private String productName;
}
