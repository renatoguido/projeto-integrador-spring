package com.example.projetointegrador.application.controller;

import com.example.projetointegrador.application.service.IJogosServiceImpl;
import com.example.projetointegrador.application.models.Jogos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JogosController {


    @Autowired
    private IJogosServiceImpl service;

    @PostMapping("/jogos")
    public ResponseEntity<Jogos> novoJogo(@RequestBody Jogos novoJogo){
        Jogos jogo = service.criarJogo(novoJogo);
        return ResponseEntity.ok(jogo);
    }

    @PutMapping("/jogos/{id}")
    public ResponseEntity<Jogos> atualizarJogo(@PathVariable ("id") Integer id, @RequestBody Jogos jogos){
        Jogos jogoAtualizado = service.atualizarJogo(jogos, id);
        return ResponseEntity.ok(jogoAtualizado);
    }


    @GetMapping("/jogos/{id}")
    public ResponseEntity<Jogos> recuperarPorId(@PathVariable ("id") Integer id, @RequestBody Jogos jogos){
        Jogos res = service.recuperarPorId(jogos, id);

        return ResponseEntity.ok(res);
    }

    @GetMapping("/jogos")
    public ResponseEntity<List<Jogos>> recuperarJogos(){
        List<Jogos> res = service.recuperarJogos();

        return ResponseEntity.ok(res);
    }

    public ResponseEntity<Void> excluirJogo(@PathVariable("id") Integer id){
        service.excluirJogo(id);
        return ResponseEntity.status(204).body(null);
    }
}
