package com.example.java10x.CadastroDeNinjas.Ninja;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class NinjaService {


    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    /* A partir do Spring 4.3+, se a classe tiver apenas um construtor, a anotação @Autowired é opcional
    CONSTRUTOR SUBSTITUIDO PELA NOTAÇÃO @RequiredArgsConstructor

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }
*/
        public List<NinjaDTO> listar () {
            List<NinjaModel> ninjas = ninjaRepository.findAll();
            return ninjas.stream()
                    .map(ninjaMapper::map)
                    .collect(Collectors.toList());
        }

        public NinjaDTO listarByID (Long id) {
            Optional<NinjaModel> ninjaID = ninjaRepository.findById(id);
            return ninjaID.map(ninjaMapper::map).orElse(null);
        }

        public NinjaDTO criarNinja (NinjaDTO ninjaDTO) {
            NinjaModel ninja = ninjaMapper.map(ninjaDTO);
            ninja = ninjaRepository.save(ninja);
            return ninjaMapper.map(ninja);
        }
        //Deletar deve ser metodo VOID
        public void deletarNinjaPorID (Long id) {
            ninjaRepository.deleteById(id);

        }
        public NinjaDTO atualizarNinja (Long id, NinjaDTO ninjaDTO) {
            Optional<NinjaModel> ninjaExist = ninjaRepository.findById(id);
            if (ninjaExist.isPresent()) {
                NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
                ninjaAtualizado.setId(id);
                NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
                return ninjaMapper.map(ninjaSalvo);
            }
            return null;
        }

    }

