package com.example.java10x.CadastroDeNinjas.Ninja;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("ninja")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/bemvindo")
    public String BemVindo() {
        return "Bem Vindo";
    }

    //Adicionar ninja (CREATE)
    @PostMapping("/adicionar")
    public ResponseEntity<NinjaDTO> adicionarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(novoNinja);
    }

    //Mostrar ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinja() {
        List<NinjaDTO> ninjas = ninjaService.listar();
        return ResponseEntity.ok(ninjas);
    }

    //Mostrar ninjas por ID (READ)
    @GetMapping("/listarID/{id}")
    public ResponseEntity<?> listarID(@PathVariable Long id) {
        NinjaDTO ninjaByID = ninjaService.listarByID(id);
        if (ninjaByID != null) {
            return ResponseEntity.ok(ninjaByID);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Ninja com o ID " + id + " não foi encontrado.");
    }

    //Alterar dados do ninja (UPDATE)
    @PutMapping("/attNinja/{id}")
    public NinjaDTO atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        return ninjaService.atualizarNinja(id, ninja);
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorID(id);
    }
}

