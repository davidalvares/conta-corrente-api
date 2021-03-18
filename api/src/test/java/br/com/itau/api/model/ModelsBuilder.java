package br.com.itau.api.model;

import org.apache.commons.lang.RandomStringUtils;

public class ModelsBuilder {

    public static ContaCorrente contaCorrente(){
        return ContaCorrente.builder()
                .id(1L)
                .nome(RandomStringUtils.randomAlphabetic(15))
                .conta(RandomStringUtils.randomAlphabetic(15))
                .chavePix(RandomStringUtils.randomAlphabetic(15))
                .cpfCnpj(RandomStringUtils.randomAlphabetic(22))
                .email(RandomStringUtils.randomAlphabetic(25))
                .celular(RandomStringUtils.randomAlphabetic(13))
                .build();
    }
}
