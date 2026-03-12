package br.edu.ifsc.fln.table_per_class.model.domain;

import br.edu.ifsc.fln.table_per_class.model.domain.Local;

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
public class Jogador extends Usuario {
    @Column(nullable = false)
    private String apelido;
    @Column(nullable = false)
    private String sobrenome;
    @Column(nullable = false)
    private String cpf;

    //Composição com Local
    @JsonIgnoreProperties("jogador")
    @OneToOne(mappedBy = "jogador", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Local local;

    public void setLocal(Local local) {
        this.local = local;
        if (local != null) {
            local.setJogador(this); // Vínculo bidirecional obrigatório
        }
    }
}
