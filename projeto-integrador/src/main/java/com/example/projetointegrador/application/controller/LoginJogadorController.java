package com.example.projetointegrador.application.controller;

import com.example.projetointegrador.application.models.Jogador;
import com.example.projetointegrador.application.models.Login;
import com.example.projetointegrador.application.service.ILoginServicempl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginJogadorController {
    @Autowired
    private ILoginServicempl service;

    @GetMapping("/login")
    public ResponseEntity<List<Login>> recuperarLogin() {
        List<Login> res = service.recuperarLogin();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/login/{id}")
    public ResponseEntity<Login> recuperarPorId(@PathVariable("id") Integer id) {
        Login res = service.recuperarPorId(id);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/login/{id}")
    public ResponseEntity<Login>atualizarLogin(@PathVariable("id") Integer id, @RequestBody Login login) {
        Login loginAtualizado = service.atualizarLogin(login, id);
        return ResponseEntity.ok(loginAtualizado);
    }
}
