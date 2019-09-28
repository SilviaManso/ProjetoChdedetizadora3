
package com.projetos.projetochdedetizadora.dao;

import com.projetos.projetochdedetizadora.model.Compra;
import org.hibernate.Session;


public class CompraDao {
     public void salvar(Compra compra) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(compra);
            session.getTransaction().commit();
            System.out.println("Registro gravado com sucesso");
        }catch (Exception erro) {
          System.out.println("Ocorreu o erro:" + erro);
        }  
    }
    
}
