package br.com.caelum.vraptor.model;

import javax.persistence.*;


@Entity
public class Professor {

    @GeneratedValue
    @Id
    private Long id;
    private String nome;
    private String pis;
    private String email;
    @OneToOne
    private Disciplina disciplinaQueMinistra;

    public Professor() {
    }

    public Disciplina getDisciplinaQueMinistra() {
        return disciplinaQueMinistra;
    }

    public void setDisciplinaQueMinistra(Disciplina disciplinaQueMinistra) {
        this.disciplinaQueMinistra = disciplinaQueMinistra;
    }

    public Professor(String nome, String pis, String email) {
        this.nome = nome;
        this.pis = pis;
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

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}