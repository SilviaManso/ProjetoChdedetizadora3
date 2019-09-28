
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
@Table(name="cliente")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)//auto icremente
    @Column(name="id", nullable = false)//coluna no banco de dados
    private Long id;
    
    @Column(name="descricao", length = 100, nullable = false)
    private String descricao; //NÃO pode ser nulo
    
    @Column(name="endereco", length = 100, nullable = true)
    private String endereco; //PODE ser nulo
    
    @Column(name="numero", length =6, nullable = true)
    private int num; //PODE ser nulo
    
    @Column(name="complemento", length = 15, nullable = true)
    private String complemento; //PODE ser nulo
    
    @ManyToOne
    @JoinColumn(name = "cidade", nullable = false)
    private Cidade cidade; //RELACIONAMENTO
    
    @Column(name="cep", length = 8, nullable = false)
    private Long cep; //NÃO pode ser nulo
    

    @Column(name="telefone1", length = 15, nullable = false)
    private Long telefone1; //NÃO pode ser nulo
    
    @Column(name="telefone2", length =15, nullable = true) 
    private Long telefone2; //PODE ser nulo
   
    @Column(name="telefone3", length =15, nullable = true)

    private Long telefone3;//PODE ser nulo
   
    @Column(name="email", length =100, nullable = true)
    private String email; //PODE ser nulo

    @Column(name="tipo_de_pessoa", length =10, nullable = false)
    private String tipoPessoa; //NÃO pode ser nulo
   
    @Column(name="cpf_cnpj", length =15, nullable = true)
    private Long cpf_cnpj; //PODE ser nulo
   
    @Column(name="insc_estadual", length =15, nullable = true)
    private String inscricaoEstatual; //PODE ser nulo
   
    @Column(name="status", nullable = false)
    private boolean status; //NÃO PODE ser nulo
   
    @Column(name="observacao", length =100, nullable = true)
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

    public Cidade getIdCidade() {
        return cidade;
    }

    public void setIdCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
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

    public Long getTelefone3() {
        return telefone3;
    }

    public void setTelefone3(Long telefone3) {
        this.telefone3 = telefone3;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public Long getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(Long cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getInscricaoEstatual() {
        return inscricaoEstatual;
    }

    public void setInscricaoEstatual(String inscricaoEstatual) {
        this.inscricaoEstatual = inscricaoEstatual;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
    
    
}
