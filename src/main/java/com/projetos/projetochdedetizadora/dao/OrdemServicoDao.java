
package com.projetos.projetochdedetizadora.dao;

import com.projetos.projetochdedetizadora.model.OrdemServico;
import com.projetos.projetochdedetizadora.model.Produto;
import org.hibernate.Session;


public class OrdemServicoDao {
     public void salvar(OrdemServico ordemServico) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(ordemServico);
            session.getTransaction().commit();
            System.out.println("Registro gravado com sucesso");
        }catch (Exception erro) {
          System.out.println("Ocorreu o erro:" + erro);
        }  
    }
        public void excluir(OrdemServico ordemServico) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete( ordemServico);
            session.getTransaction().commit();
            session.close();
            System.out.println("Registro foi excluído com sucesso!");
        } catch (Exception erro) {
            System.out.println("Ocorreu o erro: " + erro);
        }
}}
