package com.example.projetointegrador.application.controller;

import com.example.projetointegrador.application.service.IJogadorServiceImpl;
import com.example.projetointegrador.application.models.Jogador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JogadorController {

    @Autowired
    private IJogadorServiceImpl service;

    @PostMapping("/jogador")
    public ResponseEntity<Jogador> criarJogador(@RequestBody Jogador novoJogador){
        Jogador jogador = service.criarJogador(novoJogador);
        return ResponseEntity.ok(jogador);
    }

    @PutMapping("/jogador/{id}")
    public ResponseEntity<Jogador> atualizarJogo(@PathVariable("id") Integer id, @RequestBody Jogador jogador) {
        Jogador jogadorAtualizado = service.atualizarJogador(jogador, id);
        return ResponseEntity.ok(jogadorAtualizado);
    }


    @GetMapping("/jogador/{id}")
    public ResponseEntity<Jogador> recuperarPorId(@PathVariable("id") Integer id) {
        Jogador res = service.recuperarPorId(id);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/jogador")
    public ResponseEntity<List<Jogador>> recuperarJogador() {
        List<Jogador> res = service.recuperarJogador();
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/jogador/{id}")
    public ResponseEntity<Void> excluirJogador(@PathVariable("id") Integer id) {
        service.excluirJogador(id);
        return ResponseEntity.status(204).body(null);
    }

}
