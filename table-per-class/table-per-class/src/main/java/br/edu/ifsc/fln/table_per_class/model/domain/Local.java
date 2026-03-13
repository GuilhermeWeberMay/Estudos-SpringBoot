package br.edu.ifsc.fln.table_per_class.model.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class Local {
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private String cidade;
}
