
package com.projetos.projetochdedetizadora.dao;

import com.projetos.projetochdedetizadora.model.Cliente;
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
    } }
