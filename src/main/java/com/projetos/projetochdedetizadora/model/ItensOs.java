
package com.projetos.projetochdedetizadora.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itens")

public class ItensOs implements Serializable { 
   @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)//auto icremente
    @Column(name="id", nullable = false)//coluna no banco de dados
    private Long id;
   
    @Column(name="valor unitario", length = 100, nullable = false)
    private Double valorUnit;
    
    @Column(name="quantidade", length = 100, nullable = false)
    private Double quantidade;
    
    @Column(name="ordem de servico", length = 100, nullable = false)
    private Long ordemServico;
    
     @Column(name="produto", length = 100, nullable = false)
    private Long produto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorUnit() {
        return valorUnit;
    }

    public void setValorUnit(Double valorUnit) {
        this.valorUnit = valorUnit;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Long getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(Long ordemServico) {
        this.ordemServico = ordemServico;
    }

    public Long getProduto() {
        return produto;
    }

    public void setProduto(Long produto) {
        this.produto = produto;
    }
    
    
}
