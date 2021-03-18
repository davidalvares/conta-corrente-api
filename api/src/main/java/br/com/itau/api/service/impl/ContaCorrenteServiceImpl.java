package br.com.itau.api.service.impl;

import br.com.itau.api.exception.ObjectNotFoundException;
import br.com.itau.api.model.ContaCorrente;
import br.com.itau.api.repository.ContaCorrenteRepository;
import br.com.itau.api.service.ContaCorrenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContaCorrenteServiceImpl implements ContaCorrenteService {

    private final ContaCorrenteRepository repository;

    @Override
    public ContaCorrente findById(Long id) {
        var conta = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("error.conta.emptydata"));
        return conta;
    }

    @Transactional
    @Override
    public ContaCorrente save(ContaCorrente contaCorrente) {
        return repository.save(contaCorrente);
    }

    @Transactional
    @Override
    public ContaCorrente update(Long id, ContaCorrente contaCorrente) {
        var conta = this.findById(id);
        BeanUtils.copyProperties(contaCorrente,conta,"id","version");
        return save(conta);
    }

    @Override
    public ContaCorrente findByCpfCnpj(String cpfCnpj) {
        var conta = repository.findByCpfCnpj(cpfCnpj)
                .orElseThrow(() -> new ObjectNotFoundException("error.conta.empty"));
        return conta;
    }
}
