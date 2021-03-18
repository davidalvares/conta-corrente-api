package br.com.itau.api.service;

import br.com.itau.api.model.ContaCorrente;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ContaCorrenteService {

    ContaCorrente findById(Long id);

    ContaCorrente save(ContaCorrente contaCorrente);

    ContaCorrente update(Long id, ContaCorrente contaCorrente);

    ContaCorrente findByCpfCnpj(String cpfCnpj);
}
