package br.edu.ifsc.fln.table_per_class;

import br.edu.ifsc.fln.table_per_class.model.domain.Funcionario;
import br.edu.ifsc.fln.table_per_class.repository.FuncionarioRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FuncionarioController {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    };

    @PostMapping("/createFuncionario")
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario inserir(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @DeleteMapping("/deleteFuncionario/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (!funcionarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }else{
            funcionarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
            // noContent - devolve código 204 - sucesso, mas sem conteúdo
        }
    }

}
