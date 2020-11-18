package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.dao.AlunoDao;
import br.com.caelum.vraptor.model.Aluno;
import br.com.caelum.vraptor.util.JPAUtil;

import javax.persistence.EntityManager;

@br.com.caelum.vraptor.Controller
public class AgendeadController {
    @Path("/")
    public void inicio(){
    }

    @Path("/cadastrarAluno")
    public void cadastrarAluno(){

    }
    @Path("/sucesso")
    public void sucesso(Aluno aluno){
        System.out.println("ENTROU AQUI NESSA DESGRACA");
        EntityManager em = JPAUtil.criaEntityManager();
        AlunoDao alunoDao = new AlunoDao(em);
        em.getTransaction().begin();
        alunoDao.adiciona(aluno);
        em.getTransaction().commit();
    }

}
