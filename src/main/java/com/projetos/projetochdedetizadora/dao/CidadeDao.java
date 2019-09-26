
package com.projetos.projetochdedetizadora.dao;

import com.projetos.projetochdedetizadora.model.Cidade;
import java.util.ArrayList;
import java.util.List;
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
  
    //METODO PARA REEALIZAR AS CONSULTAS
    public List<Cidade> consultar(String descricao){
        List<Cidade> lista = new ArrayList<>();
        Session session = ConexaoBanco.getSessionFactory().openSession();
        session.beginTransaction();
        
        if (descricao.length() == 0){
            lista = session.createQuery(" from Cidade ").getResultList(); //retorna todos os registros
        } else {
            lista = session.createQuery(" from Cidade c where c.descricao like "+"'"+descricao+"%'").getResultList();
        }
        session.getTransaction().commit();
        session.close();
        
        return lista;
    }
    
    //METODO PARA CARREGAR O COMBOBOX COM DADOS DO BANCO DE DADOS
    public ObservableList<Cidade> comboBoxCidade(){
        List<Cidade> lista = new ArrayList<>();
        Session session = ConexaoBanco.getSessionFactory().openSession();
        session.beginTransaction();
        lista = session.createQuery(" from Cidade ").getResultList();
        session.getTransaction().commit();
        session.close();
        
        for (Cidade city: lista){
            obsList.add(city);
        }
        return obsList;
    }
    
    //METODO PARA REEALIZAR A EXCLUSÃO DE REGISTROS
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

