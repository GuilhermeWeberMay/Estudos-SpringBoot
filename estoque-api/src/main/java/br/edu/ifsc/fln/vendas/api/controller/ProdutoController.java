package br.edu.ifsc.fln.vendas.api.controller;

import java.util.List;
import java.util.Optional;

import br.edu.ifsc.fln.vendas.repository.CategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import br.edu.ifsc.fln.vendas.model.domain.Produto;
import br.edu.ifsc.fln.vendas.repository.ProdutoRepository;
import br.edu.ifsc.fln.vendas.model.domain.Categoria;

@RestController
public class ProdutoController {
    private ProdutoRepository produtoRepository;

    private CategoriaRepository categoriaRepository;

    public ProdutoController(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping("/Produto")
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    @GetMapping("/Produto/{id}")
    public ResponseEntity<Produto> pesquisar(@PathVariable Integer id) {
        return produtoRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/Produto")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto inserir(@RequestBody Produto produto) {
        produto =  produtoRepository.save(produto); // Localiza a categoria
        Optional<Categoria> c = categoriaRepository.findById(produto.getCategoria().getId());
        produto.setCategoria(c.get());
        return produto;
    }
}
