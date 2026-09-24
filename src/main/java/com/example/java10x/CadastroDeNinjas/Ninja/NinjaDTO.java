package com.example.java10x.CadastroDeNinjas.Ninja;

import com.example.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NinjaDTO {
    private Long id;
    private String nome;
    private String email;
    private String rank;
    private String skill;
    private Integer idade;
    private MissoesModel missoes;
}
