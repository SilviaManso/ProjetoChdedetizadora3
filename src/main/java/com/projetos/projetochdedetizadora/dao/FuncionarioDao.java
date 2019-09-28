
package com.projetos.projetochdedetizadora.dao;

import com.projetos.projetochdedetizadora.model.Funcionario;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
  
    //METODO PARA REEALIZAR AS CONSULTAS
    public List<Funcionario> consultar(String descricao){
        List<Funcionario> lista = new ArrayList<>();
        Session session = ConexaoBanco.getSessionFactory().openSession();
        session.beginTransaction();
        
        if (descricao.length() == 0){
            lista = session.createQuery(" from Cliente ").getResultList(); //retorna todos os registros
        } else {
            lista = session.createQuery(" from Cliente c where c.descricao like "+"'"+descricao+"%'").getResultList();
        }
        session.getTransaction().commit();
        session.close();
        
        return lista;
    }
    
    //METODO PARA CARREGAR O COMBOBOX COM DADOS DO BANCO DE DADOS
    public ObservableList<Funcionario> comboBoxCliente(){
        List<Funcionario> lista = new ArrayList<>();
        Session session = ConexaoBanco.getSessionFactory().openSession();
        session.beginTransaction();
        lista = session.createQuery(" from Cliente ").getResultList();
        session.getTransaction().commit();
        session.close();
        
        for (Funcionario funcionario: lista){
            obsList.add(funcionario);
        }
        return obsList;
    }
     
    //METODO PARA REEALIZAR A EXCLUSÃO DE REGISTROS
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