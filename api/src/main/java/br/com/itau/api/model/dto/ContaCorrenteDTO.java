package br.com.itau.api.model.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
public class ContaCorrenteDTO implements Serializable {

    private static final long serialVersionUID = -5430682091180352675L;

    private Long id;

    private String nome;

    private String celular;

    private String cpfCnpj;

    private String conta;

    private String email;

    private String chavePix;
}
