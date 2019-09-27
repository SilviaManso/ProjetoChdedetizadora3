
package com.projetos.projetochdedetizadora.dao;

import com.projetos.projetochdedetizadora.model.Fornecedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.hibernate.HibernateException;
import org.hibernate.Session;


public class FornecedorDao {
    
    private ObservableList<Fornecedor> obsList = FXCollections.observableArrayList();
    
    public void salvar(Fornecedor fornecedor) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(fornecedor);
            session.getTransaction().commit();
            session.close();
            System.out.println("Registro gravado com sucesso");
        }catch (HibernateException erro) {
            System.out.println("Ocorreu o erro:" + erro);
        }
    }

      public void excluir(Fornecedor fornecedor) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(fornecedor);
            session.getTransaction().commit();
            session.close();
            System.out.println("Registro foi excluído com sucesso!");
        } catch (HibernateException erro) {
            System.out.println("Ocorreu o erro: " + erro);
        }

    }
}
