package com.example.projetointegrador.application.dao;

import com.example.projetointegrador.application.models.Jogos;
import org.springframework.data.repository.CrudRepository;

public interface JogosDAO extends CrudRepository<Jogos, Integer> {
}
