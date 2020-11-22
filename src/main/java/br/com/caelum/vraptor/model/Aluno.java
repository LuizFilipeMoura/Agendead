package br.com.caelum.vraptor.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
public class Aluno {

    @GeneratedValue
    @Id
    private Long id;
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String rga;
    @NotNull @NotEmpty
    private String email;
    @ManyToMany
    @OrderColumn(name = "pos")
    private List<Disciplina> disciplinas;
    @ManyToMany
    @OrderColumn(name = "pos")
    private List<Reuniao> reunioes;

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Reuniao> getReunioes() {
        return reunioes;
    }

    public void setReunioes(List<Reuniao> reunioes) {
        this.reunioes = reunioes;
    }

    public Aluno() {
    }

    public Aluno(String nome, String rga, String email) {
        this.nome = nome;
        this.rga = rga;
        this.email = email;

    }

    public Long getId() {
        return id;
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

    public String getRga() {
        return rga;
    }

    public void setRga(String rga) {
        this.rga = rga;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", rga='" + rga + '\'' +
                ", email='" + email + '\'' +
                ", disciplinas=" + disciplinas +
                ", reunioes=" + reunioes +
                '}';
    }
}