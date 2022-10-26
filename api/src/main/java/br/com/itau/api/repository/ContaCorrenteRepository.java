package br.com.itau.api.repository;

import br.com.itau.api.model.ContaCorrente;
import br.com.itau.api.model.dto.ContaCorrenteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {

    @Transactional(readOnly = true)
    Optional<ContaCorrenteDTO> findByCpfCnpj(String cpfCnpj);
}
