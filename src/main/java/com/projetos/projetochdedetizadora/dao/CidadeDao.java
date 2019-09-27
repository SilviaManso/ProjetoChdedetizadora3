
package com.projetos.projetochdedetizadora.dao;

import com.projetos.projetochdedetizadora.model.Cidade;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.hibernate.HibernateException;
import org.hibernate.Session;


public class CidadeDao {
    
    private ObservableList<Cidade> obsList = FXCollections.observableArrayList();
 
    public void salvar(Cidade cidade) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(cidade);
            session.getTransaction().commit();
            session.close();
            System.out.println("Registro gravado com sucesso");
        }catch (HibernateException erro) {
          System.out.println("Ocorreu o erro:" + erro);
        }  
    }
  
     public void excluir(Cidade cidade) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(cidade);
            session.getTransaction().commit();
            session.close();
            System.out.println("Registro foi excluído com sucesso!");
        } catch (HibernateException erro) {
            System.out.println("Ocorreu o erro: " + erro);
        }

    }
}

