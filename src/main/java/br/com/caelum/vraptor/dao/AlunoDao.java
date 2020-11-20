package br.com.caelum.vraptor.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.model.Aluno;

public class AlunoDao {

    private final EntityManager em;

    public AlunoDao(EntityManager em) {
        this.em = em;
    }

    public void adiciona(Aluno aluno) {
        em.persist(aluno);
    }

    public void remove(Aluno aluno) {
        em.remove(busca(aluno));
    }

    public Aluno busca(Aluno aluno) {
        return em.find(Aluno.class, aluno.getId());
    }

    @SuppressWarnings("unchecked")
    public List<Aluno> lista() {
        return em.createQuery("select p from Aluno p").getResultList();
    }
}