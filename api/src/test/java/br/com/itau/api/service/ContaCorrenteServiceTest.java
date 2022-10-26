package br.com.itau.api.service;

import br.com.itau.api.exception.ObjectNotFoundException;
import br.com.itau.api.model.ContaCorrente;
import br.com.itau.api.model.ModelsBuilder;
import br.com.itau.api.model.dto.ContaCorrenteDTO;
import br.com.itau.api.repository.ContaCorrenteRepository;
import br.com.itau.api.service.impl.ContaCorrenteServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ContaCorrenteServiceTest {

  @InjectMocks
  private ContaCorrenteServiceImpl service;
  @Mock
  private ContaCorrenteRepository repository;

  @Test
  @DisplayName("Deve buscar conta corrente por id com sucesso, quando receber os dados corretamente")
  public void findByIdTest() {
    ContaCorrente contaCorrente = ModelsBuilder.contaCorrente();
    ContaCorrenteDTO contaCorrenteDTO = ModelsBuilder.contaCorrenteDTO();
    when(repository.findById(1L)).thenReturn(Optional.ofNullable(contaCorrente));
    var response = service.findById(1L);
    assertEquals(contaCorrenteDTO, response);
  }

  @Test
  @DisplayName("Deve salvar uma conta corrente com sucesso, quando receber os dados corretamente")
  public void salvarContaTest() {
    ContaCorrente contaCorrente = ModelsBuilder.contaCorrente();
    ContaCorrenteDTO contaCorrenteDTO = ModelsBuilder.contaCorrenteDTO();
    when(repository.save(contaCorrente)).thenReturn(contaCorrente);
    ContaCorrenteDTO response = service.salvarConta(contaCorrente);
    assertEquals(contaCorrenteDTO, response);
  }

  @Test
  public void upateTest() {
    ContaCorrente contaCorrente = ModelsBuilder.contaCorrente();
    ContaCorrenteDTO contaCorrenteDTO = ModelsBuilder.contaCorrenteDTO();
    when(repository.findById(contaCorrente.getId())).thenReturn(Optional.ofNullable(contaCorrente));
    when(repository.save(contaCorrente)).thenReturn(contaCorrente);
    var response = service.update(contaCorrente.getId(), contaCorrente);
    assertEquals(contaCorrenteDTO, response);
  }

  @Test
  public void upateObjectNotFoundExceptionTest() {
    ContaCorrente contaCorrente = ModelsBuilder.contaCorrente();
    when(repository.findById(contaCorrente.getId())).thenReturn(Optional.empty());
    assertThrows(ObjectNotFoundException.class, () -> service.update(contaCorrente.getId(), contaCorrente));
      }

  @Test
  public void findByCpfCnpjTest() {
    ContaCorrente contaCorrente = ModelsBuilder.contaCorrente();
    ContaCorrenteDTO contaCorrenteDTO = ModelsBuilder.contaCorrenteDTO();
    when(repository.findByCpfCnpj(contaCorrente.getCpfCnpj())).thenReturn(Optional.ofNullable(contaCorrenteDTO));
    var response = service.findByCpfCnpj(contaCorrente.getCpfCnpj());
    assertEquals(contaCorrenteDTO, response);
  }
}
