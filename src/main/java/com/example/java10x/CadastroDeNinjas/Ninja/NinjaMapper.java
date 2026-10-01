package com.example.java10x.CadastroDeNinjas.Ninja;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO) {

        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.id());
        ninjaModel.setNome(ninjaDTO.nome());
        ninjaModel.setEmail(ninjaDTO.email());
        ninjaModel.setRank(ninjaDTO.rank());
        ninjaModel.setSkill(ninjaDTO.skill());
        ninjaModel.setIdade(ninjaDTO.idade());
        ninjaModel.setArma(ninjaDTO.arma());
        ninjaModel.setMissoes(ninjaDTO.missoes());

        return ninjaModel;
    }
    public NinjaDTO map(NinjaModel ninjaModel) {
        return new NinjaDTO(
                ninjaModel.getId(),
                ninjaModel.getNome(),
                ninjaModel.getEmail(),
                ninjaModel.getRank(),
                ninjaModel.getSkill(),
                ninjaModel.getIdade(),
                ninjaModel.getArma(),
                ninjaModel.getMissoes());

    }

}
