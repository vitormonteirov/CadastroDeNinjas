package com.example.java10x.CadastroDeNinjas.Ninja;

import com.example.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Table (name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "rank")
    private String rank;

    @Column(name = "skillMain")
    private String skill;

    @Column(name = "idade")
    private Integer idade;

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missoes;
}
