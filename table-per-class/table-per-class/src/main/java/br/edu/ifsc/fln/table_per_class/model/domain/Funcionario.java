package br.edu.ifsc.fln.table_per_class.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
public class Funcionario extends Usuario{
    @Column(nullable = false, unique = true, columnDefinition = "char(11)")
    private String cpf;
    @Column(nullable = false)
    private String sobrenome;
    @Column(nullable = false)
    private List<String> fotos = new ArrayList<>();
}
