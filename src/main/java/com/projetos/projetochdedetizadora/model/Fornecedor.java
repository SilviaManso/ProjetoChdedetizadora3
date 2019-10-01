
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
@Table(name="fornecedor")
public class Fornecedor implements Serializable {
    @Id //chave primaria
    @GeneratedValue(strategy =GenerationType.IDENTITY)//auto incremente
    @Column(name="id", nullable = false)//coluna no banco de dados
    private Long id; //NÃO pode ser nulo
    
    @Column(name="descricao", length = 100, nullable = false)
    private String descricao; //NÃO pode ser nulo
    
    @Column(name="endereco", length = 100, nullable = true)
    private String endereco; //PODE ser nulo
    
    @Column(name="num", length = 6, nullable = true) 
    private int num; //PODE ser nulo
    
    @Column(name="complemento", length = 15, nullable = true)
    private String complemento;  //PODE ser nulo
    
    @ManyToOne
    @JoinColumn(name = "cidade", nullable = false)
    private Cidade cidade; //RELACIONAMENTO
    
    @Column(name="telefone1", length = 15, nullable = false)
    private Long telefone1; //NÃO pode ser nulo
     
    @Column(name="telefone2", length = 15, nullable = true)
    private Long telefone2; //PODE ser nulo
    
    @Column(name="email", length = 100, nullable = true)
    private String email; //PODE ser nulo
    
    @Column(name="cnpj", length = 15, nullable =false)
    private Long cnpj; //NÃO pode ser nulo
    
    @Column(name="insc_estadual", length = 15, nullable = true)
    private String inscricaoEstatual; //PODE ser nulo
    
    @Column(name="status", nullable = false)
    private boolean status; //NÃO pode ser nulo
    
    @Column(name="observacao", length = 100, nullable = true)
    private String observacao; //PODE ser nulo

    
    
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(Long telefone1) {
        this.telefone1 = telefone1;
    }

    public Long getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(Long telefone2) {
        this.telefone2 = telefone2;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Cidade getIdCidade() {
        return cidade;
    }

    public void setIdCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getInscricaoEstatual() {
        return inscricaoEstatual;
    }

    public void setInscricaoEstatual(String inscricaoEstatual) {
        this.inscricaoEstatual = inscricaoEstatual;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getTelefone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPesquisar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getEstadual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getnum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getCidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
