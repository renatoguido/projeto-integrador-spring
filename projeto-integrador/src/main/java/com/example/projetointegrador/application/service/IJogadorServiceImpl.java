package com.example.projetointegrador.application.service;

import com.example.projetointegrador.application.models.Jogador;

import java.util.List;

public interface IJogadorServiceImpl {

    Jogador criarJogador(Jogador novo);
    Jogador atualizarJogador(Jogador jogador, Integer id);
    Jogador recuperarPorId(Integer id);
    List<Jogador> recuperarJogador();
    void excluirJogador(Integer id);
}
