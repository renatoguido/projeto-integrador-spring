package com.example.projetointegrador.application.controller;

import com.example.projetointegrador.application.models.Cadastro;
import com.example.projetointegrador.application.models.Jogador;
import com.example.projetointegrador.application.service.ICadastroServiceImpl;
import com.example.projetointegrador.application.service.IJogadorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.List;

@RestController
public class CadastroController {
    @Autowired
    private ICadastroServiceImpl service;

    @Autowired
    private AuthenticationManager authenticationManager;

//    @PostMapping("/cadastro")
//    public String cadastro(@RequestBody Cadastro cadastro){
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
//                new UsernamePasswordAuthenticationToken(cadastro.getEmailDoJogador(),
//                cadastro.getSenhaLoginJogador());
//
//        Authentication authentication = this.authenticationManager
//                .authenticate(usernamePasswordAuthenticationToken);
//        var jogador = (Cadastro)authentication.getPrincipal();
//    }
    @PostMapping("/cadastro")
    public ResponseEntity<Cadastro> criarCadastro(@RequestBody Cadastro novoCadastro) {
        Cadastro cadastro = service.criarCadastro(novoCadastro);
        return ResponseEntity.ok(cadastro);
    }
    @PutMapping("/cadastro/{id}")
    public ResponseEntity<Cadastro> atualizarCadastro(@PathVariable("id") Integer id, @RequestBody Cadastro cadastro){
        Cadastro cadastroAtualizado = service.atualizarCadastro(cadastro, id);
        return ResponseEntity.ok(cadastroAtualizado);
    }
    @GetMapping("/cadastro/{id}")
    public ResponseEntity<Cadastro> recuperarPorId(@PathVariable("id") Integer id){
        Cadastro res = service.recuperarPorId(id);
        return ResponseEntity.ok(res);
    }
    @GetMapping("/cadastro")
    public ResponseEntity<List<Cadastro>> recuperarCadastro(){
        List<Cadastro> res = service.recuperarCadastro();
        return ResponseEntity.ok(res);
    }
    @PutMapping("/cadastro/{id}")
    public ResponseEntity<Void> excluirCadastro(@PathVariable("id") Integer id){
        service.excluirCadastroJogador(id);
        return ResponseEntity.status(204).body(null);
    }

}
