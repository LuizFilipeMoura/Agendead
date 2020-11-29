package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.*;
import br.com.caelum.vraptor.cache.CacheStore;
import br.com.caelum.vraptor.dao.AlunoDao;
import br.com.caelum.vraptor.dao.DisciplinaDao;
import br.com.caelum.vraptor.dao.ProfessorDao;
import br.com.caelum.vraptor.model.Aluno;
import br.com.caelum.vraptor.model.Disciplina;
import br.com.caelum.vraptor.model.Professor;
import br.com.caelum.vraptor.util.JPAUtil;
import br.com.caelum.vraptor.validator.Validator;
import com.sun.deploy.net.HttpResponse;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.net.ResponseCache;
import java.util.ArrayList;
import java.util.List;

@br.com.caelum.vraptor.Controller
public class AgendeadController {

    private Validator validator;
    private EntityManager em;
    private DisciplinaDao disciplinaDao;
    private ProfessorDao professorDao;
    private AlunoDao alunoDao;
    private Result result;
    @Inject
    public AgendeadController(Result result, EntityManager em, AlunoDao alunodao, ProfessorDao professorDao, DisciplinaDao disciplinaDao, Validator validator) {
        this.result = result;
        this.em = JPAUtil.criaEntityManager();
        this.alunoDao = alunodao;
        this.professorDao = professorDao;
        this.disciplinaDao = disciplinaDao;
        this.validator = validator;
    }
    public AgendeadController() {

    }

    @Path("/")
    public void inicio(){

        List<Professor> listaProfessores = professorDao.lista();
        List<Aluno> listaAlunos = alunoDao.lista();
        List<Disciplina> listaDisciplinas = disciplinaDao.lista();

        result.include("professoresList", listaProfessores) ;
        result.include("alunosList", listaAlunos);
        result.include("disciplinasList", listaDisciplinas);
    }



    @Path("/cadastrarAluno")
    public void cadastrarAluno(){
    }

    @Post("/editarAluno")
    public void editarAluno(Aluno aluno){
        result.include("aluno", em.find(Aluno.class, aluno.getId()));
    }
    @Get("/deletaAluno/{id}")
    public void removeAluno(String id){
        Aluno aluno = em.find(Aluno.class, Long.parseLong(id));
        em.getTransaction().begin();
        em.remove(aluno);
        em.getTransaction().commit();
        result.redirectTo("/");
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
        List<Professor> professors = new ArrayList<>();
        for(int i =0; i< professorDao.lista().size(); i++){
            if(professorDao.lista().get(i).getDisciplinaQueMinistra() == null){
                professors.add(professorDao.lista().get(i));
            }
        }
        result.include("professoresList", professors) ;
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
        System.out.println(id);
        Disciplina disciplina = em.find(Disciplina.class, Long.parseLong(id));
        disciplinaDao.remove(disciplina);
//        em.getTransaction().begin();
//        em.remove(disciplina);
//        em.getTransaction().commit();
        result.redirectTo("/");


//        Disciplina disciplina = em.find(Disciplina.class, Long.parseLong(id));
////        em.getTransaction().begin();
//        disciplinaDao.remove(disciplina);
////        em.getTransaction().commit();
//        result.redirectTo("/");
    }


    @Post("/sucessoAluno")
    public void sucessoAluno(@Valid Aluno aluno){
        validator.onErrorForwardTo(this).cadastrarAluno();
        if(aluno.getId() == null){
            alunoDao.adiciona(aluno);
        }else{
            alunoDao.altera(aluno);
        }
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
        Professor professor = em.find(Professor.class, idProfessor);
        disciplina.setAlunosMatriculados(alunos);
        disciplina.setProfessorResponsavel(professor);
        validator.onErrorForwardTo(this).cadastrarDisciplina();
        if(disciplina.getId() == null){
            disciplinaDao.adiciona(disciplina);
        }else{
            disciplinaDao.altera(disciplina);
        }

    }

}
