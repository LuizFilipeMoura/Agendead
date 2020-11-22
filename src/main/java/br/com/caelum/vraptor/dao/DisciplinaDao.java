package br.com.caelum.vraptor.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PreUpdate;


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
    public void altera(Disciplina d, Long pId) {
        Disciplina novad = em.find(Disciplina.class, d.getId());
        em.getTransaction().begin();
        Professor novop = em.find(Professor.class, pId);
        Professor antigop = em.find(Professor.class, novad.getProfessorResponsavel().getId());
        em.merge(antigop);
        antigop.setDisciplinaQueMinistra(null);
        novad.setProfessorResponsavel(null);
        em.merge(novop);
//        novop.setDisciplinaQueMinistra(d);
//        novad.setProfessorResponsavel(novop);
//        novad.setNome(d.getNome());
//        novad.setCargaHoraria(d.getCargaHoraria());
//        novad.setAlunosMatriculados(d.getAlunosMatriculados());
        em.getTransaction().commit();
    }


    public void remove(Disciplina disciplina) {
        em.remove(busca(disciplina));
    }

    public Disciplina busca(Disciplina disciplina) {
        return em.find(Disciplina.class, disciplina.getId());
    }

    @SuppressWarnings("unchecked")
    public List<Disciplina> lista() {
        return em.createQuery("select p from Disciplina p").getResultList();
    }
}