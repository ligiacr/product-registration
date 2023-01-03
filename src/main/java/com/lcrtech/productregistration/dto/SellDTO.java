package com.lcrtech.productregistration.dto;

import com.lcrtech.productregistration.model.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellDTO {

    private Long id;
    private List<ItemDTO> items;
    private BigDecimal valueTotal;
    private PaymentType paymentType;
    private String clientName;
    private LocalDateTime date;

}