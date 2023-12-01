package com.example.projetointegrador.application.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@Entity // Tabela armazenavel
@Table(name="tb_raking")
public class Ranking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ranking")
    private Long id;  // Alterado para Long para ser compatível com a geração automática de IDs
    private int pontuacao;


    @ManyToOne
    @JoinColumn(name = "id_jogador")
    private Jogador jogador;
    @ManyToOne
    @JoinColumn(name = "id_jogo")
    private Jogos jogo;



}
