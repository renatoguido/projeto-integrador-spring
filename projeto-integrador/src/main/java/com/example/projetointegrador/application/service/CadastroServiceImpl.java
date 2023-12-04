package com.example.projetointegrador.application.service;

import com.example.projetointegrador.application.dao.CadastroDAO;
import com.example.projetointegrador.application.models.Cadastro;
import com.example.projetointegrador.application.models.Jogador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroServiceImpl implements ICadastroServiceImpl {

    @Autowired
    private CadastroDAO cadastroDAO;

    public Cadastro criarCadastro(Cadastro novo) {
        return cadastroDAO.save(novo);
    }

    @Override
    public Cadastro atualizarCadastro(Cadastro cadastroAtualizado, Integer id){
        if(id != null) {
            Optional<Cadastro> cadastroExistenteOptional = cadastroDAO.findById(id);

            if (cadastroExistenteOptional.isPresent()){
                Cadastro cadastroExistente = cadastroExistenteOptional.get();

                cadastroExistente.setEmailDoJogador(cadastroAtualizado.getEmailDoJogador());
                cadastroExistente.setSenhaLoginJogador(cadastroAtualizado.getSenhaLoginJogador());
                cadastroExistente.setNicknameDoJogador(cadastroAtualizado.getNicknameDoJogador());

                return cadastroDAO.save(cadastroExistente);
            }
        }
        return null;
    }

    @Override
    public Cadastro recuperarPorId(Integer id){
        return cadastroDAO.findById(id).orElse(null);
    }
    @Override
    public List<Cadastro> recuperarCadastro() {
        return (List<Cadastro>) cadastroDAO.findAll();
    }

    @Override
    public void excluirCadastroJogador(Integer id) {
        cadastroDAO.deleteById(id);
    }

}
