package com.lcrtech.productregistration.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_sell_items",
            joinColumns = {@JoinColumn(name = "id_sell", referencedColumnName = "id_sell")},
            inverseJoinColumns = {@JoinColumn(name = "id_item", referencedColumnName = "id_item")})
    private List<Item> items = new ArrayList<>();

    @Column
    @NotNull
    private BigDecimal valueTotal;

    @Column(name = "payment_type")
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private PaymentType paymentType;

    @Column(name = "client_name")
    @NotBlank
    private String clientName;

    @Column(name = "date")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime date;

}
