package com.example.projetointegrador.application.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@Data
@Entity
@Table(name ="tb_cadastro")
public class Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cadastro")
    private Long id;

    @Email
    @Column(name="email_jogador", length = 150, unique = true)
    @NotNull
    private String emailDoJogador;

    @NotNull
    @Column(name="nickname_jogador", length = 50, unique = true)
    private String nicknameDoJogador;

    @NotNull
    @Column(name="senha_login_jogador", length = 60, unique = true)
    private String senhaLoginJogador;

}
