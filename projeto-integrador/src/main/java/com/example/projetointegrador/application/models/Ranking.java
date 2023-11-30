package com.example.projetointegrador.application.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Entity // Tabela armazenavel
@Table(name="tb_raking")
public class Ranking {

    @Id // chave primaria do banco
    @GeneratedValue(strategy = GenerationType.IDENTITY) //
    private int identificadorDePontos;
    private int pontuacao;
    private int identificacaoDoJogador;
    private int identificacaoDoJogo;
    private LocalDateTime pontuacao_dataHora;

    @ManyToOne
    @JoinColumn(name = "id_jogador")
    private Jogador jogador;
    @ManyToOne
    @JoinColumn(name = "id_jogo")
    private Jogos jogo;

    public int getIdentificadorDePontos() {
        return identificadorDePontos;
    }

    public void setIdentificadorDePontos(int identificadorDePontos) {
        this.identificadorDePontos = identificadorDePontos;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getIdentificacaoDoJogador() {
        return identificacaoDoJogador;
    }

    public void setIdentificacaoDoJogador(int identificacaoDoJogador) {
        this.identificacaoDoJogador = identificacaoDoJogador;
    }

    public int getIdentificacaoDoJogo() {
        return identificacaoDoJogo;
    }

    public void setIdentificacaoDoJogo(int identificacaoDoJogo) {
        this.identificacaoDoJogo = identificacaoDoJogo;
    }

    public LocalDateTime getPontuacao_dataHora() {
        return pontuacao_dataHora;
    }

    public void setPontuacao_dataHora(LocalDateTime pontuacao_dataHora) {
        this.pontuacao_dataHora = pontuacao_dataHora;
    }
}
