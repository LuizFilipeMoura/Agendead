package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.dao.ProdutoDao;
import br.com.caelum.vraptor.util.JPAUtil;

import javax.persistence.EntityManager;

@br.com.caelum.vraptor.Controller
public class AgendeadController {
    @Path("/")
    public void inicio(){
        EntityManager em = JPAUtil.criaEntityManager();
        ProdutoDao dao = new ProdutoDao(em);
    }

}
