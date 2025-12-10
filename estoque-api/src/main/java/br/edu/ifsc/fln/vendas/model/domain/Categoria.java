package br.edu.ifsc.fln.vendas.model.domain;

public class Categoria {
	private int id;
	private String descricao;
	
	// Construtor
	public Categoria (int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	public Categoria() {
		
	}
	
	// Métodos getters e setters
	public void setDescricao (String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao () {
		return descricao;
	}
	
	public void setId (int id) {
		this.id = id;
	}
	public int getId () {
		return id;
	}
	
}
