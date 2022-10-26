package br.com.itau.api.controller;

import br.com.itau.api.model.converter.ContaCorrenteConverter;
import br.com.itau.api.model.dto.ContaCorrenteDTO;
import br.com.itau.api.service.impl.ContaCorrenteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("contas")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContaCorrenteController {

    private final ContaCorrenteServiceImpl service;
    private final ContaCorrenteConverter converter;

    @GetMapping("/{id}")
    public ResponseEntity<ContaCorrenteDTO> findById(@PathVariable("id") Long id) {
        var contaCorrente = service.findById(id);
        return ResponseEntity.ok(contaCorrente);
    }

    @PostMapping
    public ResponseEntity<ContaCorrenteDTO> salvarConta(@RequestBody @Validated ContaCorrenteDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarConta(converter.convertToEntity(dto)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContaCorrenteDTO> update(@PathVariable("id") Long id, @RequestBody @Validated ContaCorrenteDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id,converter.convertToEntity(dto)));
    }

    @GetMapping
    public ResponseEntity<ContaCorrenteDTO> findByCpfCnpj(@RequestParam("cpfCnpj") String cpfCnpj) {
        return ResponseEntity.ok(service.findByCpfCnpj(cpfCnpj));
    }
}
