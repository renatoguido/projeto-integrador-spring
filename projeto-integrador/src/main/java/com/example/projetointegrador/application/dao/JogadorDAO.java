package com.example.projetointegrador.application.dao;

import com.example.projetointegrador.application.models.Jogador;
import org.springframework.data.repository.CrudRepository;

public interface JogadorDAO extends CrudRepository<Jogador, Integer> {
}
