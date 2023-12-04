package com.example.projetointegrador.application.dao;

import com.example.projetointegrador.application.models.Jogador;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface JogadorDAO extends CrudRepository<Jogador, Integer> {
    Optional<Object> findByNicknameDoJogador(String nickname);
}
