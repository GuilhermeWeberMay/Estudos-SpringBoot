package br.edu.ifsc.fln.vendas.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {
    @GetMapping("/mensagem")
    public String mensagem() {
        return "Olá mundo! Minha primeira requisição com API REST";
    }


}
