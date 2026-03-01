package br.edu.ifsc.fln.table_per_class.model.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Funcionario extends Usuario{
    private String cpf;
    private String sobrenome;
}
