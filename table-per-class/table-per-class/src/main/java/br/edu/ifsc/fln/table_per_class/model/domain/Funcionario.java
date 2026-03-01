package br.edu.ifsc.fln.table_per_class.model.domain;

import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
public class Funcionario extends Usuario{
    private String cpf;
    private String sobrenome;
}
