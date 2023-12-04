package com.example.projetointegrador.application.dao;

import com.example.projetointegrador.application.models.Login;
import org.springframework.data.repository.CrudRepository;


public interface LoginDao extends CrudRepository<Login, Integer> {
}
