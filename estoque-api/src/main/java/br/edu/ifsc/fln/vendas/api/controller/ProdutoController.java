package br.edu.ifsc.fln.vendas.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsc.fln.vendas.model.domain.Produto;
import br.edu.ifsc.fln.vendas.repository.ProdutoRepository;

@RestController
public class ProdutoController {
    private ProdutoRepository produtoRepository;

    public ProdutoController (ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/Produto")
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }
}
