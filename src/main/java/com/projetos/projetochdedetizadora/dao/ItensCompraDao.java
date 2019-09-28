
package com.projetos.projetochdedetizadora.dao;

import com.projetos.projetochdedetizadora.model.ItensDeCompra;
import org.hibernate.Session;


public class ItensCompraDao {
     public void salvar(ItensDeCompra itensCopra) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(itensCopra);
            session.getTransaction().commit();
            System.out.println("Registro gravado com sucesso");
        }catch (Exception erro) {
          System.out.println("Ocorreu o erro:" + erro);
        }  
    }
         public void excluir(ItensDeCompra itensCopra) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(itensCopra);
            session.getTransaction().commit();
            session.close();
            System.out.println("Registro foi excluído com sucesso!");
        } catch (Exception erro) {
            System.out.println("Ocorreu o erro: " + erro);
        }
    

    
}}
