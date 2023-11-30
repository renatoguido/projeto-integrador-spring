package com.example.projetointegrador.application.service;

import com.example.projetointegrador.application.models.Jogos;

import java.util.List;

public interface IJogosServiceImpl {

    Jogos criarJogo(Jogos novo);
    Jogos atualizarJogo(Jogos jogos, Integer id);
    Jogos recuperarPorId(Jogos jogos, Integer id);
    List<Jogos> recuperarJogos();
    void excluirJogo(Integer id);

}
