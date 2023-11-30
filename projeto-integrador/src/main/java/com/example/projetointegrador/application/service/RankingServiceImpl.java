package com.example.projetointegrador.application.service;

import com.example.projetointegrador.application.dao.JogadorDAO;
import com.example.projetointegrador.application.dao.JogosDAO;
import com.example.projetointegrador.application.dao.RankingDAO;
import com.example.projetointegrador.application.models.Jogador;
import com.example.projetointegrador.application.models.Jogos;
import com.example.projetointegrador.application.models.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingServiceImpl implements IRankingServiceImpl{

    @Autowired
    private RankingDAO rankingDAO;
    @Autowired
    private JogosDAO jogosDAO;
    @Autowired
    private JogadorDAO jogadorDAO;

    @Override
    public void inserirPontuacao(Ranking pontuacao) {
        Jogador jogador = jogadorDAO.findById(pontuacao.getIdentificacaoDoJogador())
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
        Jogos jogo = jogosDAO.findById(pontuacao.getIdentificacaoDoJogo())
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado"));
        pontuacao.setJogador(jogador);
        pontuacao.setJogo(jogo);
        rankingDAO.save(pontuacao);
    }
    @Override
    public List<Ranking> pontuacaoJogador(Integer id) {
        Jogador jogador = jogadorDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
        return (List<Ranking>) jogador.getRanking();
    }
    @Override
    public List<Ranking> pontuacaoGeral(Integer id) {
        Jogos jogo = jogosDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogo não encontrado"));
        return rankingDAO.findByJogoOrderByPontuacaoDesc(jogo);
    }
    @Override
    public void excluirPontuacao(Integer id) {
        rankingDAO.deleteById(id);
    }
}
