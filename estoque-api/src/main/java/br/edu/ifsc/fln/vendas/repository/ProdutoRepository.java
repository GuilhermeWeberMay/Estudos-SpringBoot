package br.edu.ifsc.fln.vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsc.fln.vendas.model.domain.Produto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
