package br.edu.ifsc.fln.vendas.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import br.edu.ifsc.fln.vendas.repository.FornecedorRepository;
import br.edu.ifsc.fln.vendas.model.domain.Fornecedor;

@RestController
public class FornecedorController {

    private FornecedorRepository fornecedorRepository;

    public FornecedorController(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    @GetMapping("/Fornecedor")
    public List<Fornecedor> listar() {
        return fornecedorRepository.findAll();
    }

    @GetMapping("/Fornecedor/{id}")
    public ResponseEntity<Fornecedor> pesquisar(@PathVariable Integer id) {
        return fornecedorRepository.findById(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/Fornecedor")
    @ResponseStatus(HttpStatus.CREATED)
    public Fornecedor inserir(@RequestBody Fornecedor fornecedor) {
        fornecedor = fornecedorRepository.save(fornecedor);
        return fornecedor;
    }

    @PutMapping("/Fornecedor/{id}")
    public ResponseEntity<Fornecedor> atualizar(@PathVariable Integer id, @RequestBody Fornecedor fornecedor) {
        if (!fornecedorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else  {
            fornecedor.setId(id);

            Fornecedor entidadeAtualizada = fornecedorRepository.save(fornecedor);

            return ResponseEntity.ok(entidadeAtualizada);
        }
    }

    @DeleteMapping("/Fornecedor/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        if(!fornecedorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }else{
            fornecedorRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }
    
}
