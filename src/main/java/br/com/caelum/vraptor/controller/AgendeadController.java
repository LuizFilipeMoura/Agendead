package br.com.caelum.vraptor.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
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

    @Path("/cadastrarDisciplina")
    public void cadastrarDisciplina(){
        result.include("professoresList", professorDao.lista()) ;
        result.include("alunosList", alunoDao.lista()) ;
    }


    @Post("/sucessoAluno")
    public void sucessoAluno(@Valid Aluno aluno){
        validator.onErrorForwardTo(this).cadastrarAluno();
        alunoDao.adiciona(aluno);
    }
    @Post("/sucessoProfessor")
    public void sucessoProfessor(@Valid Professor professor){
        validator.onErrorForwardTo(this).cadastrarProfessor();
        professorDao.adiciona(professor);
    }

    @Post("/sucessoDisciplina")
    public void sucessoDisciplina(@Valid Disciplina disciplina, List<Aluno> alunos, Long idProfessor){
        disciplina.setAlunosMatriculados(alunos);
        disciplina.setProfessorResponsavel(em.find(Professor.class, idProfessor));
        System.out.println(disciplina.toString());
        validator.onErrorForwardTo(this).cadastrarDisciplina();
        disciplinaDao.adiciona(disciplina);

    }

}
