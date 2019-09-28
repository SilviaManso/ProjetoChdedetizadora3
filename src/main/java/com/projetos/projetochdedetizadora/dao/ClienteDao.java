
package com.projetos.projetochdedetizadora.dao;

import com.projetos.projetochdedetizadora.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public class ClienteDao {
    
    private ObservableList<Cliente> obsList = FXCollections.observableArrayList();
    
    public void salvar(Cliente cliente) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(cliente);
            session.getTransaction().commit();
            session.close();
            System.out.println("Registro gravado com sucesso");
        }catch (HibernateException erro) {
            System.out.println("Ocorreu o erro:" + erro); 
        } 
    }
    
    //METODO PARA REALIZAR AS CONSULTAS
    public List<Cliente> consultar(String descricao){
        List<Cliente> lista = new ArrayList<>();
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
    public ObservableList<Cliente> comboBoxCliente(){
        List<Cliente> lista = new ArrayList<>();
        Session session = ConexaoBanco.getSessionFactory().openSession();
        session.beginTransaction();
        lista = session.createQuery(" from Cliente ").getResultList();
        session.getTransaction().commit();
        session.close();
        
        for (Cliente cliente: lista){
            obsList.add(cliente);
        }
        return obsList;
    }
    
    //METODO PARA REEALIZAR A EXCLUSÃO DE REGISTROS    
    public void excluir(Cliente cliente) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(cliente);
            session.getTransaction().commit();
            session.close();
            System.out.println("Registro foi excluído com sucesso!");
        } catch (HibernateException erro) {
            System.out.println("Ocorreu o erro: " + erro);
        }

    }
}