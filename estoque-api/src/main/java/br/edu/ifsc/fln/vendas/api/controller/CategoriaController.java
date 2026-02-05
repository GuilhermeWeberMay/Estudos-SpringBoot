package br.edu.ifsc.fln.vendas.api.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import br.edu.ifsc.fln.vendas.model.domain.Categoria;
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

import java.util.List;
import java.util.Optional;

@RestController
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

//    @PersistenceContext
//    private EntityManager entityManager;

    // SELECT
    @GetMapping("/Categoria")
    public List<Categoria> listar() {
        return categoriaRepository.findAll(); // Irá retornar um JSON para o navegador
    }

    // SELECT COM WHERE
    @GetMapping("/Categoria/{id}")
    public ResponseEntity<Categoria> pesquisar(@PathVariable Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()) {
            return ResponseEntity.ok(categoria.get());
        }
        return ResponseEntity.notFound().build();
//        return categoria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // SELECT COM WHERE
    @GetMapping("/Categoria/descricao/{descricao}")
    public ResponseEntity<List<Categoria>> pesquisar(@PathVariable String descricao) {
        List<Categoria> categorias = categoriaRepository.findByDescricao(descricao);
        if (categorias.size() > 0) {
            return ResponseEntity.ok(categorias);
        }
        return ResponseEntity.notFound().build();
    }

    // INSERT
    @PostMapping("/Categoria")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria inserir(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // UPDATE
    @PutMapping("/Categoria/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Integer id, @RequestBody Categoria categoria) {
        if (!categoriaRepository.existsById(id)) {
            // Conferi se o objeto existe na base de dados
            return ResponseEntity.notFound().build();
        } else{
            categoria.setId(id);
            Categoria entidadeAtualizada = categoriaRepository.save(categoria);
            return ResponseEntity.ok(entidadeAtualizada);
        }
    }

    // DELETE
    @DeleteMapping("/Categoria/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        if (!categoriaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }else{
            categoriaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
            // noContent - devolve código 204 - sucesso, mas sem conteúdo
        }

    }

}

