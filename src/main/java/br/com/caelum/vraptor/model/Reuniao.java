package br.com.caelum.vraptor.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Reuniao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private Disciplina disciplina;

    private Aluno[] alunosPermitidos;

    private String horario;

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

    public Aluno[] getAlunosPermitidos() {
        return alunosPermitidos;
    }

    public void setAlunosPermitidos(Aluno[] alunosPermitidos) {
        this.alunosPermitidos = alunosPermitidos;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
