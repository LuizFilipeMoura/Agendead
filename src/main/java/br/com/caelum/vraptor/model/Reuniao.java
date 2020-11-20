package br.com.caelum.vraptor.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Reuniao {
    @GeneratedValue
    @Id
    private Long id;
    @ManyToOne
    private Disciplina disciplina;
    @ManyToMany
    @OrderColumn(name = "list_index")
    private List<Aluno> alunosPermitidos;
    private String horario;

    public List<Aluno> getAlunosPermitidos() {
        return alunosPermitidos;
    }

    public void setAlunosPermitidos(List<Aluno> alunosPermitidos) {
        this.alunosPermitidos = alunosPermitidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
