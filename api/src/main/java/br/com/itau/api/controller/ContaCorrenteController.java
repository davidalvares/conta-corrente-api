package br.com.itau.api.controller;

import br.com.itau.api.model.ContaCorrente;
import br.com.itau.api.model.converter.ContaCorrenteConverter;
import br.com.itau.api.model.dto.ContaCorrenteDTO;
import br.com.itau.api.service.ContaCorrenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("contas")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContaCorrenteController {

    private final ContaCorrenteService service;
    private final ContaCorrenteConverter converter;

    @GetMapping("/{id}")
    public ResponseEntity<ContaCorrenteDTO> findById(@PathVariable("id") Long id) {
        Optional<ContaCorrente> contaCorrente = service.findById(id);
        return contaCorrente.isPresent() ? ResponseEntity.ok(this.converter.convertToDto(contaCorrente.get())) :
                ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<ContaCorrenteDTO> save(@RequestBody @Validated ContaCorrenteDTO dto){
        ContaCorrente contaCorrente = converter.convertToEntity(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.converter.convertToDto(service.save(contaCorrente)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContaCorrenteDTO> update(@PathVariable("id") Long id,@RequestBody @Validated ContaCorrenteDTO dto){
        ContaCorrente contaCorrente = converter.convertToEntity(dto);
        return ResponseEntity.status(HttpStatus.OK).body(this.converter.convertToDto(service.update(id,contaCorrente)));
    }

    @GetMapping()
    public ResponseEntity<ContaCorrenteDTO> findByCpfCnpj(@RequestParam("cpfCnpj") String cpfCnpj){
        Optional<ContaCorrente> conta = service.findByCpfCnpj(cpfCnpj);
        return conta.isPresent() ? ResponseEntity.ok(this.converter.convertToDto(conta.get())) : ResponseEntity.ok().build();
    }
}
