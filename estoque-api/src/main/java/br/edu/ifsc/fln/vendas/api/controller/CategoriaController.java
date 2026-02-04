package br.edu.ifsc.fln.vendas.api.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import br.edu.ifsc.fln.vendas.model.domain.Categoria;
import br.edu.ifsc.fln.vendas.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
