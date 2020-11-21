package br.com.caelum.vraptor.dao;

import br.com.caelum.vraptor.model.Reuniao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class ReuniaoDao {

    private final EntityManager em;

    @Inject
    public ReuniaoDao(EntityManager em) {
        this.em = em;
    }

    public ReuniaoDao() {
        this(null);
    }

    public void adiciona(Reuniao reuniao) {
        em.getTransaction().begin();
        em.persist(reuniao);
        em.getTransaction().commit();
    }

    public void remove(Reuniao reuniao) {
        em.remove(busca(reuniao));
    }

    public Reuniao busca(Reuniao reuniao) {
        return em.find(Reuniao.class, reuniao.getId());
    }

    @SuppressWarnings("unchecked")
    public List<Reuniao> lista() {
        return em.createQuery("select p from Reuniao p").getResultList();
    }
}