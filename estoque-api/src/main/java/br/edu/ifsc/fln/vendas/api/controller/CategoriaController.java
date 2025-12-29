package br.edu.ifsc.fln.vendas.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ifsc.fln.vendas.model.domain.Categoria;

import java.util.ArrayList;
import java.util.List;


@RestController
public class CategoriaController {
    @GetMapping("/categorias")
    public List<Categoria> listar(){
        // Cria uma lista de categorias
        List<Categoria> categorias = new ArrayList<Categoria>();
        // Cria o objeto categoria
        Categoria c1 = new Categoria();
        c1.setId(1);
        c1.setDescricao("Placa-mãe");
        Categoria c2 = new Categoria(2, "Memória RAM");
        // Adiciona os objetos a lista
        categorias.add(c1);
        categorias.add(c2);
        // Retorna a coleção
        return categorias;
    }

}
