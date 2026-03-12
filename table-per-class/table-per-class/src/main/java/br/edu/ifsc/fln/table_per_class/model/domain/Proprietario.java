package br.edu.ifsc.fln.table_per_class.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
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
    @JsonIgnoreProperties("proprietario")
    @OneToOne(mappedBy = "proprietario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Local local;

    public void setLocal(Local local) {
        this.local = local;
        if (local != null) {
            local.setProprietario(this); // Vínculo bidirecional obrigatório
        }
    }
}
