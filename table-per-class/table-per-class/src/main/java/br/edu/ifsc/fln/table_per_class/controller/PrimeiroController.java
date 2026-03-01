package br.edu.ifsc.fln.table_per_class.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {

    @GetMapping("/teste")
    public String primeiroController(){
        return "Primeiro Controller";
    }
}
