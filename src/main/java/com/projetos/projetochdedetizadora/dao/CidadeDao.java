
package com.projetos.projetochdedetizadora.dao;

import com.projetos.projetochdedetizadora.model.Cidade;
import org.hibernate.Session;


public class CidadeDao {
 
    public void salvar(Cidade cidade) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(cidade);
            session.getTransaction().commit();
            System.out.println("Registro gravado com sucesso");
        }catch (Exception erro) {
          System.out.println("Ocorreu o erro:" + erro);
        } 
        
    }
    
}

