package com.example.projetointegrador.application.service;

import com.example.projetointegrador.application.dao.LoginDao;
import com.example.projetointegrador.application.models.Jogador;
import com.example.projetointegrador.application.models.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements ILoginServicempl{

    @Autowired
    private LoginDao loginDao;

    @Override
    public Login recuperarPorId(Integer id) {
        return loginDao.findById(id).orElse(null);
    }

    @Override
    public List<Login> recuperarLogin() {
        return (List<Login>) loginDao.findAll();
    }
    @Override
    public Login atualizarLogin(Login loginAtualizado, Integer id) {
        if (id != null) {
            Optional<Login> loginExistenteOptional = loginDao.findById(id);

            if (loginExistenteOptional.isPresent()) {
                Login loginExistente = loginExistenteOptional.get();

                loginExistente.setEmail(loginAtualizado.getEmail());
                loginExistente.setEmail(loginAtualizado.getSenha());
                return loginDao.save(loginExistente);
            }
        }
        return null;
    }
}
