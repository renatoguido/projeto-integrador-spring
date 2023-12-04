package com.example.projetointegrador.application.service;

import com.example.projetointegrador.application.models.Cadastro;


import java.util.List;

public interface ICadastroServiceImpl {
    Cadastro criarCadastro(Cadastro novo);

    Cadastro atualizarCadastro(Cadastro cadastro, Integer id);

    Cadastro recuperarPorId(Integer id);

    List<Cadastro> recuperarCadastro();

    void excluirCadastroJogador(Integer id);
}
