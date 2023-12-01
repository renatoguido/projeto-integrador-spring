package com.example.projetointegrador.application.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@Entity
@Table(name = "tb_jogo")
public class Jogos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_jogo")
    private Long id;  // Alterado para Long para ser compatível com a geração automática de IDs
    @Column(name="nome_jogo", length = 100, nullable = false)
    private String nomeDoJogo;
    @Column(name="nome_autor", length = 100, nullable = false)
    private String autorDoJogo;
    @JsonIgnore
    @OneToMany(mappedBy = "jogo", cascade = CascadeType.MERGE)
    private List<Ranking> ranking;


}
