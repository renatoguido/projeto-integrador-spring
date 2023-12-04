package com.example.projetointegrador.application.service;

import com.example.projetointegrador.application.models.Ranking;

import java.util.List;

public interface IRankingServiceImpl {


    Ranking criarRanking(Ranking ranking);

    List<Ranking> pontuacaoJogador(Integer id, String nickname);

    List<Ranking> pontuacaoGeral(Integer id);
    void excluirPontuacao(Integer id);

}
