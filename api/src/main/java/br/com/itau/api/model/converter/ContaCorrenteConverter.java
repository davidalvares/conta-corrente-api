package br.com.itau.api.model.converter;

import br.com.itau.api.component.Converter;
import br.com.itau.api.model.ContaCorrente;
import br.com.itau.api.model.dto.ContaCorrenteDTO;
import org.springframework.stereotype.Component;

@Component
public class ContaCorrenteConverter extends Converter<ContaCorrente, ContaCorrenteDTO> {

    public ContaCorrenteConverter() {
        super(ContaCorrenteConverter::convertFromDTO, ContaCorrenteConverter::convertFromEntity);
    }

    public static ContaCorrente convertFromDTO(final ContaCorrenteDTO dto) {
        return ContaCorrente.builder().id(dto.getId()).nome(dto.getNome())
                .celular(dto.getCelular()).cpfCnpj(dto.getCpfCnpj())
                .conta(dto.getConta()).email(dto.getEmail()).chavePix(dto.getChavePix())
                .build();
    }

    public static ContaCorrenteDTO convertFromEntity(final ContaCorrente entity) {
        return ContaCorrenteDTO.builder().id(entity.getId()).nome(entity.getNome())
                .celular(entity.getCelular()).cpfCnpj(entity.getCpfCnpj())
                .conta(entity.getConta()).email(entity.getEmail()).chavePix(entity.getChavePix())
                .build();
    }
}