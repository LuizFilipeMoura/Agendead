package br.com.caelum.vraptor.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Professor {

    @GeneratedValue
    @Id
    private Long id;
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String pis;
    @NotNull @NotEmpty
    private String email;
    @JoinColumn(unique = true)
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