package com.example.java10x.CadastroDeNinjas.Missoes;
import com.example.java10x.CadastroDeNinjas.Ninja.NinjaDTO;
import java.util.List;

public record MissoesDTO(Long id, String nomeMissao, String dificuldade, List<NinjaDTO> ninjas) {}
