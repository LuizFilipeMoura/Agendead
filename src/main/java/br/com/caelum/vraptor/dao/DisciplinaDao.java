package br.com.caelum.vraptor.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PreUpdate;


import br.com.caelum.vraptor.model.Aluno;
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
        Professor p = em.find(Professor.class, disciplina.getProfessorResponsavel().getId());
        em.getTransaction().begin();
        em.merge(p);
        disciplina.setProfessorResponsavel(p);
        List<Aluno> alunos = disciplina.getAlunosMatriculados();
        List<Aluno> a = new ArrayList<Aluno>();
        for(int i = 0; i < alunos.size(); i++){
            Aluno aluno = alunos.get(i);
            Aluno aluno1 = em.find(Aluno.class, aluno.getId());
            em.merge(aluno1);
            a.add(aluno1);
        }
        disciplina.setAlunosMatriculados(a);
        p.setDisciplinaQueMinistra(disciplina);
        em.persist(disciplina);
        em.getTransaction().commit();
    }
    public void altera(Disciplina novad) {
        Disciplina antigaD = em.find(Disciplina.class, novad.getId());
        Professor p = em.find(Professor.class, novad.getProfessorResponsavel().getId());
        Professor antigop = em.find(Professor.class, antigaD.getProfessorResponsavel().getId());
        em.getTransaction().begin();
        em.merge(antigaD);
        em.merge(p);
        em.merge(antigop);


        antigop.setDisciplinaQueMinistra(null);

        em.getTransaction().commit();
        em.getTransaction().begin();



        p.setDisciplinaQueMinistra(antigaD);
        antigaD.setProfessorResponsavel(p);
        antigaD.setNome(novad.getNome());
        antigaD.setCargaHoraria(novad.getCargaHoraria());
        antigaD.setHorario(novad.getHorario());
        List<Aluno> alunosAntigo = antigaD.getAlunosMatriculados();

        if(antigaD.getAlunosMatriculados() != null){
//            List<Aluno> alunosAntigo = antigaD.getAlunosMatriculados();

            for(int i = 0; i < alunosAntigo.size(); i++){
                Aluno aluno = alunosAntigo.get(i);
                Aluno aluno1 = em.find(Aluno.class, aluno.getId());
                em.merge(aluno1);
                aluno1.getDisciplinas().remove(antigaD);
            }
        }

        if(novad.getAlunosMatriculados() != null){
            List<Aluno> alunos = novad.getAlunosMatriculados();
            List<Aluno> a = new ArrayList<Aluno>();
            for(int i = 0; i < alunos.size(); i++){
                Aluno aluno = alunos.get(i);
                Aluno aluno1 = em.find(Aluno.class, aluno.getId());
                em.merge(aluno1);
                aluno1.getDisciplinas().remove(antigaD);
                aluno1.getDisciplinas().add(antigaD);
                a.add(aluno1);
            }
            antigaD.setAlunosMatriculados(a);
        }else if(antigaD.getAlunosMatriculados() != null){
//            List<Aluno> alunosAntigo = antigaD.getAlunosMatriculados();
            List<Aluno> a = new ArrayList<Aluno>();

            for(int i = 0; i < alunosAntigo.size(); i++){
                Aluno aluno = alunosAntigo.get(i);
                Aluno aluno1 = em.find(Aluno.class, aluno.getId());
                em.merge(aluno1);
                aluno1.getDisciplinas().remove(antigaD);
            }
            antigaD.setAlunosMatriculados(a);
        }
        em.getTransaction().commit();
    }

    public void remove(Disciplina disciplina) {
        disciplina = em.find(Disciplina.class, disciplina.getId());
        em.getTransaction().begin();
        em.merge(disciplina);
        for(int i = 0; i < disciplina.getAlunosMatriculados().size(); i++){
            Aluno aluno = em.find(Aluno.class, disciplina.getAlunosMatriculados().get(i).getId());
            em.merge(aluno);
            aluno.getDisciplinas().remove(disciplina);
        }
        em.remove(disciplina);
        em.getTransaction().commit();
    }

    public Disciplina busca(Disciplina disciplina) {
        return em.find(Disciplina.class, disciplina.getId());
    }

    @SuppressWarnings("unchecked")
    public List<Disciplina> lista() {
        return em.createQuery("select p from Disciplina p").getResultList();
    }
}