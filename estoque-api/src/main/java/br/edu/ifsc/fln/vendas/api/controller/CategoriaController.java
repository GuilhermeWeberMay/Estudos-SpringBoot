package br.edu.ifsc.fln.vendas.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ifsc.fln.vendas.model.domain.Categoria;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriaController {
	
	@GetMapping("/categorias")
	public List<Categoria> listar(){
		
		List<Categoria> categorias = new ArrayList<>();
	
		Categoria c1 = new Categoria();
		c1.setId(2);
		c1.setDescricao("Uma categoria ai");
		Categoria c2 = new Categoria(1, "segunda categoria ai");
		
		categorias.add(c1);
		categorias.add(c2);
		
		return categorias;
	}
}
