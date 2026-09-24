package com.example.java10x.CadastroDeNinjas.Missoes;


import com.example.java10x.CadastroDeNinjas.Ninja.NinjaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {

    private Long id;
    private String nomeMissao;
    private String dificuldade;
    private List<NinjaDTO> ninjas;

}
