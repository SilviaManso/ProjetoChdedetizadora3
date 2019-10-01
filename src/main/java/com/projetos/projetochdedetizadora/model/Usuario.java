
package com.projetos.projetochdedetizadora.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")

public class Usuario implements Serializable {
     @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)//auto icremente
    @Column(name="id", nullable = false)//coluna no banco de dados
    private Long id; //NÃO pode ser nulo
     
    @Column(name="login", length = 100, nullable = false)
    private String login; //NÃO pode ser nulo
    
    @Column(name="senha", length = 6, nullable = false)
    private String senha; //NÃO pode ser nulo
    
    @Column(name="confirma senha", length = 6, nullable = true)
    private String confirmarSenha; //NÃO VAI SER ENVIADO PRO BANCO DE DADOS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    public String getPesquisar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getAtivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
