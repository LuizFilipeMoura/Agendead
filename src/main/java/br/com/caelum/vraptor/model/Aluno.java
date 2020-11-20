package br.com.caelum.vraptor.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Aluno {

    @GeneratedValue
    @Id
    private Long id;
    private String nome;
    private String rga;
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

}