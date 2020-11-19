package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.dao.AlunoDao;
import br.com.caelum.vraptor.dao.ProfessorDao;
import br.com.caelum.vraptor.model.Aluno;
import br.com.caelum.vraptor.model.Professor;
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

    @Path("/cadastrarProfessor")
    public void cadastrarProfessor(){

    }
    @Path("/sucessoAluno")
    public void sucessoAluno(Aluno aluno){
        System.out.println("ENTROU AQUI NESSA DESGRACA");
        EntityManager em = JPAUtil.criaEntityManager();
        AlunoDao alunoDao = new AlunoDao(em);
        em.getTransaction().begin();
        alunoDao.adiciona(aluno);
        em.getTransaction().commit();
    }
    @Path("/sucessoProfessor")
    public void sucessoProfessor(Professor professor){
        System.out.println("ENTROU AQUI NESSA DESGRACA");
        EntityManager em = JPAUtil.criaEntityManager();
        ProfessorDao professorDao = new ProfessorDao(em);
        em.getTransaction().begin();
        professorDao.adiciona(professor);
        em.getTransaction().commit();
    }

}
