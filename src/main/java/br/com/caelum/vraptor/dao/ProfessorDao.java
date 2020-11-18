package br.com.caelum.vraptor.dao;

import java.util.List;

import javax.persistence.EntityManager;


import br.com.caelum.vraptor.model.Professor;

public class ProfessorDao {

    private final EntityManager em;

    public ProfessorDao(EntityManager em) {
        this.em = em;
    }

    public void adiciona(Professor professor) {
        em.persist(professor);
    }

    public void remove(Professor professor) {
        em.remove(busca(professor));
    }

    public Professor busca(Professor professor) {
        return em.find(Professor.class, professor.getId());
    }

    @SuppressWarnings("unchecked")
    public List<Professor> lista() {
        return em.createQuery("select p from professor p").getResultList();
    }
}