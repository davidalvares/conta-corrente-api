package br.com.itau.api.service;

import br.com.itau.api.model.ContaCorrente;
import br.com.itau.api.model.dto.ContaCorrenteDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ContaCorrenteService {

    ContaCorrenteDTO findById(Long id);

    ContaCorrenteDTO salvarConta(ContaCorrente contaCorrente);

    ContaCorrenteDTO update(Long id, ContaCorrente contaCorrente);

    ContaCorrenteDTO findByCpfCnpj(String cpfCnpj);
}
