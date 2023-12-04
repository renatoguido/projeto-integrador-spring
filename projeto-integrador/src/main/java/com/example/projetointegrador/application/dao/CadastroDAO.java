package com.example.projetointegrador.application.dao;

import com.example.projetointegrador.application.models.Cadastro;
import org.springframework.data.repository.CrudRepository;

public interface CadastroDAO extends CrudRepository<Cadastro, Integer> {
}
