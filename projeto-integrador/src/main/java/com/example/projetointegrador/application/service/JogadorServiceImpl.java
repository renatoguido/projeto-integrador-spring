package com.example.projetointegrador.application.service;

import com.example.projetointegrador.application.dao.JogadorDAO;
import com.example.projetointegrador.application.models.Jogador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorServiceImpl implements IJogadorServiceImpl{

    @Autowired
    private JogadorDAO jogadorDAO;

    @Override
    public Jogador criarJogador(Jogador novo) {
        String nickname = novo.getNicknameDoJogador();

        Optional<Object> JogadorExistente = jogadorDAO.findByNicknameDoJogador(nickname);
        if (JogadorExistente.isPresent()) {
            throw new RuntimeException();
        }

        return jogadorDAO.save(novo);
    }


    @Override
    public Jogador atualizarJogador(Jogador jogadorAtualizado, Integer id) {
        if (id != null) {
            Optional<Jogador> jogadorExistenteOptional = jogadorDAO.findById(id);

            if (jogadorExistenteOptional.isPresent()) {
                Jogador jogadorExistente = jogadorExistenteOptional.get();

                jogadorExistente.setNomeDoJogador(jogadorAtualizado.getNomeDoJogador());
                jogadorExistente.setEmailDoJogador(jogadorAtualizado.getEmailDoJogador());
                jogadorExistente.setNicknameDoJogador(jogadorAtualizado.getNicknameDoJogador());

                return jogadorDAO.save(jogadorExistente);
            }
        }
        return null;
    }

    @Override
    public Jogador recuperarPorId(Integer id) {
        return jogadorDAO.findById(id).orElse(null);
    }

    @Override
    public List<Jogador> recuperarJogador() {
        return (List<Jogador>) jogadorDAO.findAll();
    }

    @Override
    public void excluirJogador(Integer id) {
        jogadorDAO.deleteById(id);
    }
}
