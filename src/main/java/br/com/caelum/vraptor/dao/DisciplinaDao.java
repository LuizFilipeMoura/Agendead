package br.com.caelum.vraptor.dao;

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
        Professor p = em.find(Professor.class, pId);
        em.getTransaction().begin();
        disciplina.setProfessorResponsavel(p);
        p.setDisciplinaQueMinistra(disciplina);
        em.merge(p);
        em.persist(disciplina);
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