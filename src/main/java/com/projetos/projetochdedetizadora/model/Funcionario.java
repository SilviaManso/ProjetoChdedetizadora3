
package com.projetos.projetochdedetizadora.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="funcionario")
public class Funcionario implements Serializable {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id; //NÃO pode ser nulo
     
    @Column(name="descricao", length = 100, nullable = false) 
    private String descricao; //NÃO pode ser nulo
    
    @Column(name="endereço", length = 100, nullable = false)
    private String endereco; //NÃO pode ser nulo
    
    @Column(name="numero", length = 6, nullable = false)
    private int num; //NÃO pode ser nulo
    
    @ManyToOne
    @JoinColumn(name = "cidade", nullable = false)
    private Cidade cidade; //RELACIONAMENTO
    
    @Column(name="telefone", length = 15, nullable = false)
    private Long telefone1; //NÃO pode ser nulo
    
    @Column(name="funcao", length = 30, nullable = false)
    private String funcao; //NÃO pode ser nulo
    
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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    } 
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Long getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(Long telefone1) {
        this.telefone1 = telefone1;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPesquisar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getAtivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getTelefone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
