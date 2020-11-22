package br.com.caelum.vraptor.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;


import br.com.caelum.vraptor.model.Professor;

public class ProfessorDao {

    private final EntityManager em;

    @Inject
    public ProfessorDao(EntityManager em) {
        this.em = em;
    }
    public ProfessorDao() {
        this(null);
    }
    public void adiciona(Professor professor) {
        em.getTransaction().begin();
        em.persist(professor);
        em.getTransaction().commit();
    }

    public void altera(Professor professor) {
        em.getTransaction().begin();
        Professor novo = em.find(Professor.class, professor.getId());
        novo.setDisciplinaQueMinistra(professor.getDisciplinaQueMinistra());
        novo.setNome(professor.getNome());
        novo.setEmail(professor.getEmail());
        novo.setPis(professor.getPis());
        em.getTransaction().commit();
    }

    public void remove(Professor professor) {
        em.remove(busca(professor));
    }

    public Professor busca(Professor professor) {
        return em.find(Professor.class, professor.getId());
    }

    @SuppressWarnings("unchecked")
    public List<Professor> lista() {
        return em.createQuery("select p from Professor p").getResultList();
    }
}