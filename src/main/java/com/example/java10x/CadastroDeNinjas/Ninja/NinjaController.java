package com.example.java10x.CadastroDeNinjas.Ninja;

import com.example.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class NinjaController {

    @Autowired
    private NinjaRepository ninjaRepository;

    @GetMapping("/bemvindo")
    public String BemVindo(){
        return "Bem Vindo";
    }

    //Adicionar ninja (CREATE)
    @PostMapping("/adicionar")
    public String criarNinja(){
        return "Adicionando ninja";
    }

    //Mostrar ninjas (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listar(){
        return ninjaRepository.findAll();
    }

    //Mostrar ninjas por ID (READ)
    @GetMapping("/listaID")
    public String listarID(){
        return "Listando ninjas por ID";
    }

    //Alterar dados do ninja (UPDATE)
    @PutMapping("/attNinja")
    public String atualizarNinja(){
        return "Atualizando ninja";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletarNinja")
    public String deletarNinja(){
        return "Deletando ninja";
    }
}
