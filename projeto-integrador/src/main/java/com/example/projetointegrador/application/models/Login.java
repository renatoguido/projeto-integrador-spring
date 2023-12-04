package com.example.projetointegrador.application.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name ="tb_login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_jogador")
    private Long id;

    @Email
    @Column(name="email_login_jogador", length = 150)
    @NotNull
    private String email;

    @Column(name="senha_login_jogador", length = 90)
    @NotNull
    private String senha;
}
