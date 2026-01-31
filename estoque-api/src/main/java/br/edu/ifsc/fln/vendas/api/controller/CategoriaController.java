package br.edu.ifsc.fln.vendas.api.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import br.edu.ifsc.fln.vendas.model.domain.Categoria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriaController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/Categoria")
    public List<Categoria> listar() {
        TypedQuery<Categoria> pesquisa =
                entityManager.createQuery("from Categoria where id=2", Categoria.class);
        // Colocar a consulta SQL dentro das ""
        return pesquisa.getResultList(); // Irá retornar um JSON para o navegador
    }
}
