package com.lcrtech.productregistration.dto;

import com.lcrtech.productregistration.model.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellDTO {

    private String clientName;
    private PaymentType paymentType;
    private BigDecimal valueTotal;
    private List<ItemDTO> items;

}