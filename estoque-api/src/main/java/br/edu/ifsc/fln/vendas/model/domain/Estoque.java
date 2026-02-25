package br.edu.ifsc.fln.vendas.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class Estoque {

    @Id
    @Column(name = "id_produto", nullable = false)
    private int id;
    private int quantidade;
    @Column(name = "qtd_maxima", nullable = false)
    private int quantidadeMaxima;
    @Column(name = "qtd_minima", nullable = false)
    private int quantidadeMinima;
    @Enumerated(EnumType.STRING)
    @Column(name = "situacao", nullable = false)
    private ESituacao eSituacao = ESituacao.ATIVO;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getQuantidadeMaxima() {
        return quantidadeMaxima;
    }

    public void setQuantidadeMaxima(int quantidadeMaxima) {
        this.quantidadeMaxima = quantidadeMaxima;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public ESituacao geteSituacao() {
        return eSituacao;
    }

    public void seteSituacao(ESituacao eSituacao) {
        this.eSituacao = eSituacao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void repor(int quantidade) throws Exception {
        if (this.eSituacao != ESituacao.ATIVO) {
            throw new IllegalStateException("Estoque inativo ou bloqueado, retirada não permitida. "+geteSituacao().getDescricao());
        }
        if (this.quantidade + quantidade > this.quantidadeMaxima) {
            throw new Exception("Quantidade excede o máximo permitido no estoque");
        }
        this.quantidade += quantidade;
    }

    public void retirar(int quantidade) throws Exception {
        if (this.eSituacao != ESituacao.ATIVO) {
            throw new IllegalStateException("Estoque inativo ou bloqueado, retirada não permitida. "+geteSituacao().getDescricao());
        }
        if (this.quantidade - quantidade < 0) {
            throw new Exception("Quantidade insuficiente no estoque");
        }
        this.quantidade -= quantidade;
    }
}
