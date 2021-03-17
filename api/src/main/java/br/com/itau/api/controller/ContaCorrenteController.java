package br.com.itau.api.controller;

import br.com.itau.api.service.ContaCorrenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ContaCorrenteController {

    private final ContaCorrenteService service;
}
