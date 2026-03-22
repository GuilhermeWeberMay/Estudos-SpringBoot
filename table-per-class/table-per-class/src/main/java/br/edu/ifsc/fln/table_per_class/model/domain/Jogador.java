package br.edu.ifsc.fln.table_per_class.model.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
public class Jogador extends Usuario {
    @Column(nullable = false)
    private String apelido;
    @Column(nullable = false)
    private String sobrenome;
    @Column(nullable = false)
    private String cpf;

    //Composição com Local
    @Embedded
    private Local local;
}
