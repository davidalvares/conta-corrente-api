package br.com.itau.api.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
@Entity
@Table(name = "conta_corrente")
public class ContaCorrente implements Serializable {

    private static final long serialVersionUID = 2251396180018529054L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta_corrente")
    private Long id;

    private String nome;

    private String celular;

    @Column(name = "cpf_cnpj")
    private String cpfCnpj;

    private String conta;

    private String email;

    @Column(name = "chave_pix")
    private String chavePix;
}
