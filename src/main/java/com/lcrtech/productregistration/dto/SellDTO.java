package com.lcrtech.productregistration.dto;

import com.lcrtech.productregistration.model.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellDTO {

private String clientName;
private PaymentType paymentType;
private BigDecimal valueTotal;
private String name;
private BigDecimal price;
private Integer quantity;
private BigDecimal subTotal;
}
