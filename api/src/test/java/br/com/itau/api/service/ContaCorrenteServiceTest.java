package br.com.itau.api.service;

import br.com.itau.api.exception.ObjectNotFoundException;
import br.com.itau.api.model.ContaCorrente;
import br.com.itau.api.model.ModelsBuilder;
import br.com.itau.api.repository.ContaCorrenteRepository;
import br.com.itau.api.service.impl.ContaCorrenteServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Optional;

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

    @Test
    public void findByIdTest(){
        ContaCorrente contaCorrente = ModelsBuilder.contaCorrente();
        doReturn(Optional.ofNullable(contaCorrente)).when(repository).findById(anyLong());
        service.findById(contaCorrente.getId());
        verify(repository,times(1)).findById(anyLong());
    }

    @Test
    public void upateTest(){
        ContaCorrente contaCorrente = ModelsBuilder.contaCorrente();
        doReturn(Optional.ofNullable(contaCorrente)).when(repository).findById(anyLong());
        doReturn(contaCorrente).when(repository).save(any(ContaCorrente.class));
        service.update(contaCorrente.getId(),contaCorrente);
        verify(repository,times(1)).findById(anyLong());
        verify(repository,times(1)).save(any(ContaCorrente.class));
    }

    @Test
    public void upateObjectNotFoundExceptionTest(){
        ContaCorrente contaCorrente = ModelsBuilder.contaCorrente();
        doReturn(Optional.empty()).when(repository).findById(anyLong());
        Assertions.assertThrows(ObjectNotFoundException.class, ()->service.update(contaCorrente.getId(),contaCorrente));
        verify(repository,times(1)).findById(anyLong());
    }

    @Test
    public void findByCpfCnpjTest(){
        ContaCorrente contaCorrente = ModelsBuilder.contaCorrente();
        doReturn(Optional.ofNullable(contaCorrente)).when(repository).findByCpfCnpj(anyString());
        service.findByCpfCnpj(contaCorrente.getCpfCnpj());
        verify(repository,times(1)).findByCpfCnpj(anyString());
    }
}