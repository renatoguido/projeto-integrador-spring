package com.example.projetointegrador.application.service;

import com.example.projetointegrador.application.dao.JogadorDAO;
import com.example.projetointegrador.application.dao.JogosDAO;
import com.example.projetointegrador.application.dao.RankingDAO;
import com.example.projetointegrador.application.models.Jogador;
import com.example.projetointegrador.application.models.Jogos;
import com.example.projetointegrador.application.models.Ranking;
import jakarta.persistence.EntityNotFoundException;
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
    public Ranking criarRanking(Ranking ranking) {

            Jogador jogador = jogadorDAO.findById(ranking.getJogador().getId().intValue())
                    .orElseThrow(() -> new EntityNotFoundException("Jogador não encontrado"));

            Jogos jogo = jogosDAO.findById(ranking.getJogo().getId().intValue())
                    .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado"));

            var rankingCreated = new Ranking();
            rankingCreated.setJogador(jogador);
            rankingCreated.setJogo(jogo);

            rankingCreated.setPontuacao(ranking.getPontuacao());

            return rankingDAO.save(rankingCreated);
    }
    @Override
    public List<Ranking> pontuacaoJogador(Integer id, String nickname) {
        if (id != null) {
            Jogador jogador = jogadorDAO.findById(id)
                    .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
            return jogador.getRanking();
        } else if (nickname != null && !nickname.isEmpty()) {
            Jogador jogador = (Jogador) jogadorDAO.findByNicknameDoJogador(nickname)
                    .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
            return jogador.getRanking();
        } else {
            throw new IllegalArgumentException("ID ou Nickname deve ser fornecido");
        }
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
