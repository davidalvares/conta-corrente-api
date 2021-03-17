package br.com.itau.api.service.impl;

import br.com.itau.api.exception.NegocioException;
import br.com.itau.api.model.ContaCorrente;
import br.com.itau.api.repository.ContaCorrenteRepository;
import br.com.itau.api.service.ContaCorrenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContaCorrenteServiceImpl implements ContaCorrenteService {

    private final ContaCorrenteRepository repository;

    @Override
    public Optional<ContaCorrente> findById(Long id) {
        var idConta = repository.findById(id)
                .orElseThrow(() -> new NegocioException("Conta corrente não encontrada", HttpStatus.NOT_FOUND));
        return Optional.ofNullable(idConta);
    }

    @Transactional
    @Override
    public ContaCorrente save(ContaCorrente contaCorrente) {
        return repository.save(contaCorrente);
    }

    @Transactional
    @Override
    public ContaCorrente update(Long id, ContaCorrente contaCorrente) {
        Optional<ContaCorrente> data = this.findById(id);
        if (data.isEmpty())
            throw new NegocioException(String.format("Não foi possivel atualizar a conta corrente com o id:",id), HttpStatus.BAD_REQUEST);
        BeanUtils.copyProperties(contaCorrente,data.get(),"id","version");
        return save(data.get());
    }

    @Override
    public Optional<ContaCorrente> findByCpfCnpj(String cpfCnpj) {
        Optional<ContaCorrente> data = repository.findByCpfCnpj(cpfCnpj);
        if (!data.isPresent())
            throw new NegocioException("Não foi possivel encontrar a conta corrente com o cpf/cnpj informado",HttpStatus.NOT_FOUND);
        return data;
    }
}
