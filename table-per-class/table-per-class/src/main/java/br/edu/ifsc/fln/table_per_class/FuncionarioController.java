package br.edu.ifsc.fln.table_per_class;

import br.edu.ifsc.fln.table_per_class.model.domain.Funcionario;
import br.edu.ifsc.fln.table_per_class.repository.FuncionarioRepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
}
