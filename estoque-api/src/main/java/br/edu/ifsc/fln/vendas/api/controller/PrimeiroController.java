package br.edu.ifsc.fln.vendas.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Isso significa que esse controller será de uma API REST
public class PrimeiroController {

    // Todos os recursos da API são criados a partir de métodos
    @GetMapping("/mensagem")
    public String mensagem() {
        return "Olá mundo! Esta é minha primeira resposta com API REST.";
    }
}
