
package com.projetos.projetochdedetizadora.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="compra")
public class Compra implements Serializable {
    
     @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)//auto icremente
    @Column(name="id", nullable = false)//coluna no banco de dados
    private Long id;
     
   @Column(name="compra", length = 100, nullable = false)  
    private Double valorCompra;
    private Long compra ;
    
     @Column(name="data compra", length = 100, nullable = false)
    private LocalDate dataCompra;
    private String observacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Long getFornecedor() {
        return compra;
    }

    public void setFornecedor(Long fornecedor) {
        this.compra = fornecedor;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
}
