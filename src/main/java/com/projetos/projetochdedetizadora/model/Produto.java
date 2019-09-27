
package com.projetos.projetochdedetizadora.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="produto")

public class Produto implements Serializable {
    
     @Id //chave primaria
    @GeneratedValue(strategy =GenerationType.IDENTITY)//auto incremente
    @Column(name="id", nullable = false)//coluna no banco de dados
    private Long id; //NÃO pode ser nulo
     
    @Column(name="descricao", length = 100, nullable = false)
    private String descricao; //NÃO pode ser nulo
    
    @Column(name="quantidade", length = 100, nullable = false)
    private float quantidade; //NÃO pode ser nulo
    
    @Column(name="unidade", length = 100, nullable = false)
    private String unidade; //NÃO pode ser nulo
    
    @Column(name="valor custo", length = 100, nullable = false)
    private Double valorCusto; //NÃO pode ser nulo
    
    private String idFornecedor; //RELACIONAMENTO
    
    @Column(name="observacao", length = 100, nullable = true)
    private String observacao; //PODE ser nulo
    
    @Column(name="status", length = 100, nullable = false)
    private String status; //NÃO pode ser nulo

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(Double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public String getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(String idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
