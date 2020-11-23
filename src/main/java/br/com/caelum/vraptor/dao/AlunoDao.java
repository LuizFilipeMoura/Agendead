package br.com.caelum.vraptor.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.model.Aluno;


public class AlunoDao {

    private final EntityManager em;
    @Inject
    public AlunoDao(EntityManager em) {
        this.em = em;
    }
    public AlunoDao(){
        this(null);
    }

    public void adiciona(Aluno aluno) {
        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();
    }

    public void altera(Aluno aluno) {
//        em.getTransaction().begin();

        Aluno novo = em.find(Aluno.class, aluno.getId());
        em.merge(novo);
        novo.setNome(aluno.getNome());
        novo.setEmail(aluno.getEmail());
        novo.setDisciplinas(aluno.getDisciplinas());
        novo.setRga(aluno.getRga());
//        em.getTransaction().commit();
    }
    
    public void remove(Aluno aluno) {
        em.remove(busca(aluno));
    }

    public Aluno busca(Aluno aluno) {
        return em.find(Aluno.class, aluno.getId());
    }

    @SuppressWarnings("unchecked")
    public List<Aluno> lista() {
//        em.getTransaction().begin();
        return em.createQuery("select p from Aluno p").getResultList();
    }
}