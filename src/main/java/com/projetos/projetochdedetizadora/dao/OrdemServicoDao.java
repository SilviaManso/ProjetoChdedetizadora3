
package com.projetos.projetochdedetizadora.dao;

import com.projetos.projetochdedetizadora.model.OrdemServico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public class OrdemServicoDao {
       private final ObservableList<OrdemServico> obsList = FXCollections.observableArrayList();
 
    public void salvar(OrdemServico ordem) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(ordem);
            session.getTransaction().commit();
            session.close();
            System.out.println("Registro gravado com sucesso");
        }catch (HibernateException erro) {
          System.out.println("Ocorreu o erro:" + erro);
        }  
    }
  
     public void excluir(OrdemServico ordem) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(ordem);
            session.getTransaction().commit();
            session.close();
            System.out.println("Registro foi excluído com sucesso!");
        } catch (HibernateException erro) {
            System.out.println("Ocorreu o erro: " + erro);
        }

    }
    
}
