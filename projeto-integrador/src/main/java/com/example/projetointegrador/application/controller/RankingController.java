package com.example.projetointegrador.application.controller;

import com.example.projetointegrador.application.service.IRankingServiceImpl;
import com.example.projetointegrador.application.models.Ranking;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@RestController
public class RankingController {

    @Autowired
    private IRankingServiceImpl service;
    @PostMapping("/ranking")
    public ResponseEntity<Ranking> inserirPontuacao(@RequestBody Ranking pontuacao) {
        service.inserirPontuacao(pontuacao);
        return ResponseEntity.ok(pontuacao);
    }
    @GetMapping("/ranking/jogador/{id}")
    public ResponseEntity<List<Ranking>> pontuacaoJogador(@PathVariable Integer id) {
        List<Ranking> pontuacoes = service.pontuacaoJogador(id);
        return ResponseEntity.ok(pontuacoes);
    }
    @GetMapping("/ranking/jogo/{id}")
    public ResponseEntity<List<Ranking>> pontuacaoGeral(@PathVariable Integer id) {
        List<Ranking> historico = service.pontuacaoGeral(id);
        return ResponseEntity.ok(historico);
    }
    @DeleteMapping("/ranking/{id}")
    public ResponseEntity<Void> excluirPontuacao(@PathVariable Integer id) {
        service.excluirPontuacao(id);
        return ResponseEntity.status(204).body(null);
    }
}
