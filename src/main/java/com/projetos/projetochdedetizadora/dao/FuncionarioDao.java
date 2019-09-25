
package com.projetos.projetochdedetizadora.dao;

import com.projetos.projetochdedetizadora.model.Funcionario;
import org.hibernate.Session;


public class FuncionarioDao {
    
    public void salvar(Funcionario funcionario) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(funcionario);
            session.getTransaction().commit();
            System.out.println("Registro gravado com sucesso");
        }catch (Exception erro) {
            System.out.println("Ocorreu o erro:" + erro);
        }  
    }
}
