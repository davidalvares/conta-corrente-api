package br.com.itau.api.model.converter;


import br.com.itau.api.component.Converter;
import br.com.itau.api.model.ContaCorrente;
import br.com.itau.api.model.dto.ContaCorrenteDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ContaCorrenteConverter extends Converter<ContaCorrente, ContaCorrenteDTO> {


    public ContaCorrenteConverter() {
        super(ContaCorrenteConverter:: convertFromDTO,);
    }

    private static ContaCorrente convertFromDTO(final ContaCorrenteDTO dto){
        return ContaCorrente.builder().id(dto.getId()).nome(dto.getNome())
                .celular(dto.getCelular()).cpfCnpj(dto.getCpfCnpj())
                .conta(dto.getConta()).email(dto.getEmail()).chavePix(dto.getChavePix())
                .build();
    }


    private static ContaCorrente convertFromEntity(final ContaCorrente entity){
        return ContaCorrente.builder().id(entity.getId()).nome(entity.getNome())
                .celular(entity.getCelular()).cpfCnpj(entity.getCpfCnpj())
                .conta(entity.getConta()).email(entity.getEmail()).chavePix(entity.getChavePix())
                .build();

    }
