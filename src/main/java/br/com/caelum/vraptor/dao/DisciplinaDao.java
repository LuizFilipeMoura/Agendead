package br.com.caelum.vraptor.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PreUpdate;


import br.com.caelum.vraptor.model.Aluno;
import br.com.caelum.vraptor.model.Disciplina;
import br.com.caelum.vraptor.model.Professor;

public class DisciplinaDao {

    private final EntityManager em;

    @Inject
    public DisciplinaDao(EntityManager em) {
        this.em = em;
    }
    public DisciplinaDao(){
        this(null);
    }

    public void adiciona(Disciplina disciplina, Long pId) {
        em.getTransaction().begin();
        List<Aluno> alunos = disciplina.getAlunosMatriculados();
        Professor p = em.find(Professor.class, pId);
        em.merge(p);
        List<Aluno> a = new ArrayList<Aluno>();
        disciplina.setAlunosMatriculados(a);
        for(int i = 0; i < alunos.size(); i++){
            Aluno aluno = em.find(Aluno.class, alunos.get(i).getId());
            em.merge(aluno);
            disciplina.getAlunosMatriculados().add(aluno);
            System.out.println(aluno.getNome());
            List<Disciplina> lista = aluno.getDisciplinas() == null? new ArrayList<Disciplina>(): aluno.getDisciplinas();
            lista.add(disciplina);
            aluno.setDisciplinas(lista);
        }

        disciplina.setProfessorResponsavel(p);
        em.persist(disciplina);
        p.setDisciplinaQueMinistra(disciplina);
        em.getTransaction().commit();
    }
    public void altera(Disciplina novad, Long pId) {
        Disciplina antigaD = em.find(Disciplina.class, novad.getId());
        em.getTransaction().begin();
        em.merge(antigaD);
        Professor novop = em.find(Professor.class, pId);
        Professor antigop = em.find(Professor.class, antigaD.getProfessorResponsavel().getId());
        em.merge(antigop);

        antigop.setDisciplinaQueMinistra(null);
        em.getTransaction().commit();
        em.getTransaction().begin();
        em.merge(novop);

        novop.setDisciplinaQueMinistra(novad);

        antigaD.setProfessorResponsavel(novop);
        antigaD.setNome(novad.getNome());
        antigaD.setCargaHoraria(novad.getCargaHoraria());
        antigaD.setHorario(novad.getHorario());
        antigaD.setAlunosMatriculados(novad.getAlunosMatriculados());
        em.getTransaction().commit();
    }

    public void remove(Disciplina disciplina) {
        disciplina = em.find(Disciplina.class, disciplina.getId());
        em.getTransaction().begin();
        em.merge(disciplina);
        for(int i = 0; i < disciplina.getAlunosMatriculados().size(); i++){
            Aluno aluno = em.find(Aluno.class, disciplina.getAlunosMatriculados().get(i).getId());
            em.merge(aluno);
            aluno.getDisciplinas().remove(disciplina);
        }
        em.remove(disciplina);
        em.getTransaction().commit();
    }

    public Disciplina busca(Disciplina disciplina) {
        return em.find(Disciplina.class, disciplina.getId());
    }

    @SuppressWarnings("unchecked")
    public List<Disciplina> lista() {
        return em.createQuery("select p from Disciplina p").getResultList();
    }
}