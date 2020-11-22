package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.dao.AlunoDao;
import br.com.caelum.vraptor.dao.DisciplinaDao;
import br.com.caelum.vraptor.dao.ProfessorDao;
import br.com.caelum.vraptor.dao.ReuniaoDao;
import br.com.caelum.vraptor.model.Aluno;
import br.com.caelum.vraptor.model.Disciplina;
import br.com.caelum.vraptor.model.Professor;
import br.com.caelum.vraptor.util.JPAUtil;
import br.com.caelum.vraptor.validator.Validator;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.List;

@br.com.caelum.vraptor.Controller
public class AgendeadController {

    private Validator validator;
    private EntityManager em;
    private ReuniaoDao reuniaoDao;
    private DisciplinaDao disciplinaDao;
    private ProfessorDao professorDao;
    private AlunoDao alunoDao;
    private Result result;
    @Inject
    public AgendeadController(Result result, EntityManager em, AlunoDao alunodao, ProfessorDao professorDao, DisciplinaDao disciplinaDao, ReuniaoDao reuniaoDao, Validator validator) {
        this.result = result;
        this.em = JPAUtil.criaEntityManager();
        this.alunoDao = alunodao;
        this.professorDao = professorDao;
        this.disciplinaDao = disciplinaDao;
        this.reuniaoDao = reuniaoDao;
        this.validator = validator;
    }
    public AgendeadController() {

    }

    @Path("/")
    public void inicio(){
        result.include("professoresList", professorDao.lista()) ;
        result.include("alunosList", alunoDao.lista()) ;
        result.include("disciplinasList", disciplinaDao.lista());
    }



    @Path("/cadastrarAluno")
    public void cadastrarAluno(){

    }
    @Path("/reuniao")
    public void reuniao(){

    }

    @Path("/cadastrarProfessor")
    public void cadastrarProfessor(){
    }
    @Post("/editarProfessor")
    public void editarProfessor(Professor professor){
        result.include("professor", em.find(Professor.class, professor.getId()));

    }

    @Get("/deletaProfessor/{id}")
    public void removeProfessor(String id){
        Professor disciplina = em.find(Professor.class, Long.parseLong(id));
        em.getTransaction().begin();
        em.remove(disciplina);
        em.getTransaction().commit();
        result.redirectTo("/");
    }


    @Path("/cadastrarDisciplina")
    public void cadastrarDisciplina(){
        result.include("professoresList", professorDao.lista()) ;
        result.include("alunosList", alunoDao.lista()) ;
    }
    @Post("/editarDisciplina")
    public void editarDisciplina(Disciplina disciplina){
        result.include("professoresList", professorDao.lista()) ;
        result.include("alunosList", alunoDao.lista()) ;
        result.include("disciplina", em.find(Disciplina.class, disciplina.getId()));
    }
    @Get("/deletaDisciplina/{id}")
    public void removeDisciplina(String id){
        Disciplina disciplina = em.find(Disciplina.class, Long.parseLong(id));
        em.getTransaction().begin();
        em.remove(disciplina);
        em.getTransaction().commit();
        result.redirectTo("/");
    }


    @Post("/sucessoAluno")
    public void sucessoAluno(@Valid Aluno aluno){
        validator.onErrorForwardTo(this).cadastrarAluno();
        alunoDao.adiciona(aluno);
    }
    @Post("/sucessoProfessor")
    public void sucessoProfessor(@Valid Professor professor){
        validator.onErrorForwardTo(this).cadastrarProfessor();
        if(professor.getId() == null){
            professorDao.adiciona(professor);
        }else{
            professorDao.altera(professor);
        }
    }

    @Post("/sucessoDisciplina")
    public void sucessoDisciplina(@Valid Disciplina disciplina, List<Aluno> alunos, Long idProfessor){
        disciplina.setAlunosMatriculados(alunos);
        validator.onErrorForwardTo(this).cadastrarDisciplina();
        if(disciplina.getId() == null){
            disciplinaDao.adiciona(disciplina, idProfessor);
        }else{
//            System.out.println(disciplina);
            disciplinaDao.altera(disciplina, idProfessor);
        }
//        p.setDisciplinaQueMinistra(disciplina);
//        professorDao.altera(p);

//        for(int i = 0; i < alunos.size(); i++){
//            Aluno aluno = em.find(Aluno.class, alunos.get(i).getId());
//            aluno.getDisciplinas().add(disciplina);
//            System.out.println(aluno);
//            alunoDao.altera(aluno);
//        }
//        em.getTransaction().commit();
    }

}
