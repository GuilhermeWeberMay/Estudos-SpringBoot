package br.edu.ifsc.fln.table_per_class.model.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public abstract class Usuario {
    private String nome;
    private String email;
    private String senha;
    private String telefone;
}
