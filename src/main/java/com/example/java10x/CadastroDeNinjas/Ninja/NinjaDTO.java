package com.example.java10x.CadastroDeNinjas.Ninja;

import com.example.java10x.CadastroDeNinjas.Missoes.MissoesModel;

public record NinjaDTO(Long id, String nome, String email, String rank, String skill, Integer idade, MissoesModel missoes){}

