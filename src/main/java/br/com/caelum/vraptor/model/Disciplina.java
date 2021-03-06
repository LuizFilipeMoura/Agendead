package br.com.caelum.vraptor.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Disciplina {
    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", professorResponsavel="  +
                ", alunosMatriculados="  +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }

    @GeneratedValue
    @Id
    private Long id;
    @NotNull @NotEmpty
    private String nome;
    @JoinColumn(unique = true)
    @OneToOne
    private Professor professorResponsavel;
    @ManyToMany(cascade = CascadeType.ALL)
    @OrderColumn(name = "pos")
    private List<Aluno> alunosMatriculados;
    private String horario;

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    private Integer cargaHoraria;

    @PreRemove
    public void preRemove() {

        professorResponsavel.setDisciplinaQueMinistra(null);
        List<Aluno> vazia = new ArrayList<Aluno>();
        setAlunosMatriculados(vazia);

    }

//    @PreUpdate
//    public void preUpdate() {
//        if(professorResponsavel != null){
//            professorResponsavel.setDisciplinaQueMinistra(null);
//        }
//    }
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
