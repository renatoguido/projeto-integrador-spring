package com.example.projetointegrador.application.models;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Data
@Entity
@Table(name ="tb_jogador")
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_jogador")
    private Long id;

    @Column(name="nome_jogador", length = 50)
    @NotNull
    private String nomeDoJogador;
    @Column(name="email_jogador", length = 50)
    @NotNull
    private String emailDoJogador;

    @NotNull
    @Column(name="nickname_jogador", length = 20)
    private String nicknameDoJogador;
    @JsonIgnore
    @OneToMany(mappedBy = "jogador", cascade = CascadeType.MERGE)
    private List<Ranking> ranking;



}
