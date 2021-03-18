package br.com.itau.api.service;

import br.com.itau.api.model.ContaCorrente;
import br.com.itau.api.model.ModelsBuilder;
import br.com.itau.api.repository.ContaCorrenteRepository;
import br.com.itau.api.service.impl.ContaCorrenteServiceImpl;
import org.junit.Before;
import org.junit.Test;


import static org.mockito.Mockito.*;

public class ContaCorrenteServiceTest {

    private ContaCorrenteService service;
    private ContaCorrenteRepository repository;

    @Before
    public void setup(){
        repository = mock(ContaCorrenteRepository.class);
        service = new ContaCorrenteServiceImpl(repository);
    }

    @Test
    public void saveTest(){
        ContaCorrente contaCorrente = ModelsBuilder.contaCorrente();
        doReturn(contaCorrente).when(repository).save(any(ContaCorrente.class));
        service.save(contaCorrente);
        verify(repository,times(1)).save(any(ContaCorrente.class));
    }
}
