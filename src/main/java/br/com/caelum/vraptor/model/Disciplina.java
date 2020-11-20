package br.com.caelum.vraptor.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Disciplina {

    @GeneratedValue
    @Id
    private Long id;
    private String nome;
    @OneToOne
    private Professor professorResponsavel;
    @ManyToMany
    @OrderColumn(name = "pos")
    private List<Aluno> alunosMatriculados;
    private Integer cargaHoraria;

    public Long getId() {
        return id;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void setAlunosMatriculados(List<Aluno> alunosMatriculados) {
        this.alunosMatriculados = alunosMatriculados;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(Professor professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
