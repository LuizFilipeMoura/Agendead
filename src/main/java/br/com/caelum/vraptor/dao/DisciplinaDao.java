package br.com.caelum.vraptor.dao;

import java.util.List;

import javax.persistence.EntityManager;


import br.com.caelum.vraptor.model.Disciplina;
import br.com.caelum.vraptor.model.Professor;

public class DisciplinaDao {

    private final EntityManager em;

    public DisciplinaDao(EntityManager em) {
        this.em = em;
    }

    public void adiciona(Disciplina disciplina) {
        em.persist(disciplina);
    }

    public void remove(Disciplina disciplina) {
        em.remove(busca(disciplina));
    }

    public Disciplina busca(Disciplina disciplina) {
        return em.find(Disciplina.class, disciplina.getId());
    }

    @SuppressWarnings("unchecked")
    public List<Disciplina> lista() {
        return em.createQuery("select p from disciplina p").getResultList();
    }
}