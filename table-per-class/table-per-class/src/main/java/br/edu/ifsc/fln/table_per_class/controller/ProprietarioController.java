package br.edu.ifsc.fln.table_per_class.controller;

import br.edu.ifsc.fln.table_per_class.model.domain.Jogador;
import br.edu.ifsc.fln.table_per_class.model.domain.Local;
import br.edu.ifsc.fln.table_per_class.model.domain.Proprietario;
import br.edu.ifsc.fln.table_per_class.repository.ProprietarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProprietarioController {

    private final ProprietarioRepository proprietarioRepository;

    public ProprietarioController(ProprietarioRepository proprietarioRepository) {
        this.proprietarioRepository = proprietarioRepository;
    }

    @PostMapping("/createProprietario")
    @ResponseStatus(HttpStatus.CREATED)
    public Proprietario inserir(@RequestBody Proprietario funcionario) {
        if (funcionario.getLocal() != null) {
            funcionario.getLocal().setProprietario(funcionario);
        }

        return proprietarioRepository.save(funcionario);
    }
}
