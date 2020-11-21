package br.com.caelum.vraptor.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;


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

    public void adiciona(Disciplina disciplina) {
        em.getTransaction().begin();
        em.persist(disciplina);
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