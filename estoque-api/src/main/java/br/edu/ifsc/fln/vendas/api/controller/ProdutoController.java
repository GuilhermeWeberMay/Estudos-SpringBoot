package br.edu.ifsc.fln.vendas.api.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ifsc.fln.vendas.model.domain.Produto;
import br.edu.ifsc.fln.vendas.model.domain.Categoria;

@RestController
public class ProdutoController {
	
	@GetMapping("/produto")
	public Produto apresentar() {
		Categoria c1 = new Categoria(1, "Armazenamento");
		Produto produto = new Produto(1, "Samsung", "SSD da Samsung", new BigDecimal("199.45") , c1);
		return produto;
	}

}
