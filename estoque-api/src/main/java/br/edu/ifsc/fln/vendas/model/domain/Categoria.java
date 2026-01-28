package br.edu.ifsc.fln.vendas.model.domain;

public class Categoria {
    private int id;
    private String descricao;

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }
}
