package com.lcrtech.productregistration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_item")
    private Long id;

    @Column
    @NotNull
    private BigDecimal subTotal;

    @Column
    @NotNull
    private Integer quantity;

    @NotNull
    @Column(name = "id_product_fk")
    private Integer productId;

    @NotBlank
    @Column(name = "product_name")
    private String productName;
}
