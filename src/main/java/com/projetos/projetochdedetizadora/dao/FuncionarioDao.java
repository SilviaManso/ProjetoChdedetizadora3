
package com.projetos.projetochdedetizadora.dao;

import com.projetos.projetochdedetizadora.model.Funcionario;

import org.hibernate.HibernateException;
import org.hibernate.Session;


public class FuncionarioDao {
    
    private ObservableList<Funcionario> obsList = FXCollections.observableArrayList();
    
    public void salvar(Funcionario funcionario) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(funcionario);
            session.getTransaction().commit();
            session.close();
            System.out.println("Registro gravado com sucesso");
        }catch (HibernateException erro) {
            System.out.println("Ocorreu o erro:" + erro);
        }  
    }

      public void excluir(Funcionario funcionario) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(funcionario);
            session.getTransaction().commit();
            session.close();
            System.out.println("Registro foi excluído com sucesso!");
        } catch (HibernateException erro) {
            System.out.println("Ocorreu o erro: " + erro);
        }

    }
}
