package com.example.projetointegrador.application.dao;

import com.example.projetointegrador.application.models.Jogador;
import com.example.projetointegrador.application.models.Jogos;
import com.example.projetointegrador.application.models.Ranking;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RankingDAO extends CrudRepository<Ranking, Integer> {
    List<Ranking> findByJogoOrderByPontuacaoDesc(Jogos jogo);

    Optional<Ranking> findByJogadorAndJogo(Jogador jogador, Jogos jogo);
}
