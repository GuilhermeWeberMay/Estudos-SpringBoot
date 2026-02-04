package br.edu.ifsc.fln.vendas.api.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import br.edu.ifsc.fln.vendas.model.domain.Categoria;
import br.edu.ifsc.fln.vendas.repository.CategoriaRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/Categoria")
    public List<Categoria> listar() {
        return categoriaRepository.findAll(); // Irá retornar um JSON para o navegador
    }

    @GetMapping("/Categoria/{id}")
    public ResponseEntity<Categoria> pesquisar(@PathVariable Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()) {
            return ResponseEntity.ok(categoria.get());
        }
        return ResponseEntity.notFound().build();
//        return categoria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/Categoria/descricao/{descricao}")
    public ResponseEntity<List<Categoria>> pesquisar(@PathVariable String descricao) {
        List<Categoria> categorias = categoriaRepository.findByDescricao(descricao);
        if(categorias.size()>0){
            return ResponseEntity.ok(categorias);
        }
        return ResponseEntity.notFound().build();
    }
}
