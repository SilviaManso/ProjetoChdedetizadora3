
package com.projetos.projetochdedetizadora.dao;

import com.projetos.projetochdedetizadora.model.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public class ProdutoDao {
    
        
    private ObservableList<Produto> obsList = FXCollections.observableArrayList();
 
    public void salvar(Produto produto) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(produto);
            session.getTransaction().commit();
            session.close();
            System.out.println("Registro gravado com sucesso");
        }catch (HibernateException erro) {
          System.out.println("Ocorreu o erro:" + erro);
        }  
    }
  
     public void excluir(Produto produto) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(produto);
            session.getTransaction().commit();
            session.close();
            System.out.println("Registro foi excluído com sucesso!");
        } catch (HibernateException erro) {
            System.out.println("Ocorreu o erro: " + erro);
        }

    }
    
}
