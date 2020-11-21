package br.com.caelum.vraptor.producers;

import br.com.caelum.vraptor.util.JPAUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;

public class EntityManagerProducer {
    @Produces @ApplicationScoped
    public EntityManager produzEM(){
        return JPAUtil.criaEntityManager();
    }
}
