package com.lcrtech.productregistration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_sell")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sell implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_sell")
    private Long id;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "tb_sell_product",
            joinColumns = {@JoinColumn(name = "id_sell", referencedColumnName = "id_sell")},
            inverseJoinColumns = {@JoinColumn(name = "id_product", referencedColumnName = "id_product")})
    private List<Product> products;

    @Column
    @NotNull
    private BigDecimal value;

    @Column
    @NotNull
    private Integer quantity;

}
