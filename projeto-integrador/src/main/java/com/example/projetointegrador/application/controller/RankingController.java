package com.example.projetointegrador.application.controller;

import com.example.projetointegrador.application.service.IRankingServiceImpl;
import com.example.projetointegrador.application.models.Ranking;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RankingController {

    @Autowired
    private IRankingServiceImpl service;

    @PostMapping("/ranking")
    public ResponseEntity<Ranking> criarRanking(@RequestBody Ranking ranking) {
        return ResponseEntity.ok(service.criarRanking(ranking));
    }


    //apenas com id: /ranking/jogador?id=1
    //apenas com nick/ranking/jogador?nickname=example
    //com ambos:/ranking/jogador?id=1&nickname=example
    @GetMapping("/ranking/jogador")
    public ResponseEntity<List<Ranking>> pontuacaoJogador(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "nickname", required = false) String nickname) {

            List<Ranking> pontuacoes = service.pontuacaoJogador(id, nickname);
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
