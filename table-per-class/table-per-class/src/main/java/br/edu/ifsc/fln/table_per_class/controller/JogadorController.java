package br.edu.ifsc.fln.table_per_class.controller;

import br.edu.ifsc.fln.table_per_class.model.domain.Funcionario;
import br.edu.ifsc.fln.table_per_class.model.domain.Jogador;
import br.edu.ifsc.fln.table_per_class.model.domain.Local;
import br.edu.ifsc.fln.table_per_class.repository.JogadorRepository;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JogadorController {

    private final JogadorRepository jogadorRepository;

    public JogadorController(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    };

    @PostMapping("/createJogador")
    @ResponseStatus(HttpStatus.CREATED)
    public Jogador inserir(@RequestBody Jogador funcionario) {
        // Instancie os objetos
        Jogador jogador = new Jogador();
        Local local = new Local();

        // Faça a associação (dos dois lados, se for bidirecional)
        local.setJogador(jogador);
        jogador.setLocal(local);

        return jogadorRepository.save(funcionario);
    }

    @GetMapping("/Jogador/{id}")
    public ResponseEntity<Jogador> pesquisar(@PathVariable Integer id) {
        return jogadorRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/getJogador")
    public List<Jogador> read() {
        return jogadorRepository.findAll();
    }

}
