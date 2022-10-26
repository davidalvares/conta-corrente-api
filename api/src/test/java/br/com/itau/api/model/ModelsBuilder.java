package br.com.itau.api.model;

import br.com.itau.api.model.dto.ContaCorrenteDTO;

public class ModelsBuilder {

    public static ContaCorrente contaCorrente() {
        return ContaCorrente.builder()
                .id(1L)
                .nome("Nome")
                .conta("Conta")
                .chavePix("PIX")
                .cpfCnpj("CpfCnpj")
                .email("Email")
                .celular("310894859435")
                .build();
    }

    public static ContaCorrenteDTO contaCorrenteDTO() {
        return ContaCorrenteDTO.builder()
                .id(1L)
                .nome("Nome")
                .conta("Conta")
                .chavePix("PIX")
                .cpfCnpj("CpfCnpj")
                .email("Email")
                .celular("310894859435")
                .build();
    }
}
