package com.lcrtech.productregistration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tb_client")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id_client")
        private Long id;

        @Column
        @NotNull
        private String name;

        @Column
        @NotNull
        @Email
        private String email;

        @Column
        @NotNull
        @CPF
        private String cpf;
}
