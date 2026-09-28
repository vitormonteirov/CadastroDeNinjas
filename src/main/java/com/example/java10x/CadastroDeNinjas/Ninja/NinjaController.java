package com.example.java10x.CadastroDeNinjas.Ninja;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/bemvindo")
    public String BemVindo() {
        return "Bem Vindo";
    }

    //Adicionar ninja (CREATE)
    @PostMapping("/adicionar")
    public String criarNinja() {
        return "Adicionando ninja";
    }

    //Mostrar ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinja() {
        List<NinjaDTO> ninjas = ninjaService.listar();
        return ResponseEntity.ok(ninjas);
    }

    //Mostrar ninjas por ID (READ)
    @GetMapping("/listaID")
    public String listarID() {
        return "Listando ninjas por ID";
    }

    //Alterar dados do ninja (UPDATE)
    @PutMapping("/attNinja")
    public String atualizarNinja() {
        return "Atualizando ninja";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletarNinja")
    public String deletarNinja() {
        return "Deletando ninja";
    }
}

