package com.example.projetointegrador.application.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@Entity
@Table(name="tb_raking")
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ranking")
    private Long id;
    private int pontuacao;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_jogador", nullable = false)
    private Jogador jogador;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_jogo", nullable = false)
    private Jogos jogo;



}
