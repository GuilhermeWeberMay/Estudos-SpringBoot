package br.edu.ifsc.fln.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsc.fln.vendas.model.domain.Categoria;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    // Criação de um novo método
    List<Categoria> findByDescricao(String descricao);
}
