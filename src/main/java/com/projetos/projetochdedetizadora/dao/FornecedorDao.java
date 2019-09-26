
package com.projetos.projetochdedetizadora.dao;

import com.projetos.projetochdedetizadora.model.Fornecedor;
import java.util.ArrayList;
import java.util.List;
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

     //METODO PARA REEALIZAR AS CONSULTAS
    public List<Fornecedor> consultar(String descricao){
        List<Fornecedor> lista = new ArrayList<>();
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
    public ObservableList<Fornecedor> comboBoxCliente(){
        List<Fornecedor> lista = new ArrayList<>();
        Session session = ConexaoBanco.getSessionFactory().openSession();
        session.beginTransaction();
        lista = session.createQuery(" from Cliente ").getResultList();
        session.getTransaction().commit();
        session.close();
        
        for (Fornecedor fornecedor: lista){
            obsList.add(fornecedor);
        }
        return obsList;
    }
    
    //METODO PARA REEALIZAR A EXCLUSÃO DE REGISTROS
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
