package com.example.java10x.CadastroDeNinjas.Ninja;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<String> adicionarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado: "+ novoNinja.nome()+ " seu ID é: "+novoNinja.id());
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
    public ResponseEntity<?> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
       NinjaDTO ninja = ninjaService.atualizarNinja(id,ninjaAtualizado);
       if (ninja != null) {
           return ResponseEntity.ok(ninja);
       }
       else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("O ninja com ID: "+ " não existe no banco de dados.");
       }

    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if (ninjaService.listarByID(id) != null) {
            ninjaService.deletarNinjaPorID(id);
            return ResponseEntity.ok("Ninja deletado com sucesso.");
        }
        else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja de ID "+ id + " não encontrado.");
            }
    }
}

