package br.edu.ifsc.fln.table_per_class.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Proprietario extends Usuario {
    private String cnpj;

    //Composição com Local
    @Embedded
    private Local local;
}
