package br.edu.ifsc.fln.table_per_class.repository;

import br.edu.ifsc.fln.table_per_class.model.domain.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Integer> {
}
