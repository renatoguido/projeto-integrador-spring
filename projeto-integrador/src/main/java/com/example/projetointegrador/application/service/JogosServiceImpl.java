package com.example.projetointegrador.application.service;

import com.example.projetointegrador.application.dao.JogosDAO;
import com.example.projetointegrador.application.models.Jogos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogosServiceImpl implements IJogosServiceImpl{

    @Autowired
    private JogosDAO jogosDAO;

    @Override
    public Jogos criarJogo(Jogos novo) {
        return jogosDAO.save(novo);
    }

    @Override
    public Jogos atualizarJogo(Jogos jogoAtualizado, Integer id) {
        if (id != null) {
            Optional<Jogos> jogadorExistenteOptional = jogosDAO.findById(id);

            if (jogadorExistenteOptional.isPresent()) {
                Jogos jogoExistente = jogadorExistenteOptional.get();

                jogoExistente.setNomeDoJogo(jogoAtualizado.getNomeDoJogo());
                jogoExistente.setAutorDoJogo(jogoAtualizado.getAutorDoJogo());

                return jogosDAO.save(jogoExistente);
            }
        }
        return null;
    }

    @Override
    public Jogos recuperarPorId(Jogos jogos,Integer id) {
        return jogosDAO.findById(id).orElse(null);
    }

    @Override
    public List<Jogos> recuperarJogos() {
        return (List<Jogos>) jogosDAO.findAll();
    }

    @Override
    public void excluirJogo(Integer id) {
        jogosDAO.deleteById(id);
    }


}
