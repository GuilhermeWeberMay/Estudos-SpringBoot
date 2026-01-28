package br.edu.ifsc.fln.vendas.api.controller;

import br.edu.ifsc.fln.vendas.model.domain.Categoria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriaController {
    @GetMapping("/Categoria")
    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<>();

        Categoria categoria = new Categoria();
        categoria.setId(1);
        categoria.setDescricao("Categoria 1");

        Categoria categoria2 = new Categoria(2, "Categoria 2");

        categorias.add(categoria);
        categorias.add(categoria2);

        return categorias; // Irá retornar um JSON para o navegador
    }
}
