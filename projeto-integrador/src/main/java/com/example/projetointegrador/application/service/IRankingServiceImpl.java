package com.example.projetointegrador.application.service;

import com.example.projetointegrador.application.models.Ranking;

import java.util.List;

public interface IRankingServiceImpl {

    void inserirPontuacao(Ranking pontuacao);
    List<Ranking> pontuacaoJogador(Integer id);
    List<Ranking> pontuacaoGeral(Integer id);
    void excluirPontuacao(Integer id);

}
