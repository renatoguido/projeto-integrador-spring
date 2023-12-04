package com.example.projetointegrador.application.service;

import com.example.projetointegrador.application.models.Login;

import java.util.List;

public interface ILoginServicempl {
    Login recuperarPorId(Integer id);

    List<Login> recuperarLogin();

    Login atualizarLogin(Login login, Integer id);

}
