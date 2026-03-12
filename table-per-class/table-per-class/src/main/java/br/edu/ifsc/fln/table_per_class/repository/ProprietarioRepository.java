package br.edu.ifsc.fln.table_per_class.repository;

import br.edu.ifsc.fln.table_per_class.model.domain.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Integer> {
}
