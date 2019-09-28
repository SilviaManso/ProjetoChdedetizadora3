
package com.projetos.projetochdedetizadora.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cidade")
public class Cidade implements Serializable  {
    @Id //chave primaria
    @GeneratedValue(strategy =GenerationType.IDENTITY)//auto incremente
    @Column(name="id", nullable = false)//coluna no banco de dados
    private Long id; //NÃO pode ser nulo
   
    @Column(name="descricao",length = 100, nullable = false)
    private String descricao; //NÃO pode ser nulo
   
    @Column(name="uf",length = 2, nullable = false)
    private String uf; //NÃO pode ser nulo
     
    @Column(name="cep",length = 8, nullable = false)
    private Long cep; //NÃO pode ser nulo
    
    //-----> RELACIONAMENTOS
    @OneToMany (mappedBy = "cidade", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Funcionario> funcionario = new ArrayList();
    
    @OneToMany (mappedBy = "cidade", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Fornecedor> fornecedor = new ArrayList();
    
    @OneToMany (mappedBy = "cidade", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Cliente> cliente = new ArrayList();
     
    @Column(name="status", nullable = false)
    private boolean status; //NÃO pode ser nulo
  
    
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(List<Funcionario> funcionario) {
        this.funcionario = funcionario;
    }

    public List<Fornecedor> getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(List<Fornecedor> fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public String toString() {
        return descricao;
    }
    
}
