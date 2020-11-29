package br.com.caelum.vraptor.model;

import br.com.caelum.vraptor.dao.DisciplinaDao;
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
    @ManyToMany(cascade = CascadeType.ALL)
    @OrderColumn(name = "pos")
    private List<Disciplina> disciplinas;


    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
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

    @PreRemove
    public void preRemove() {

    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", rga='" + rga + '\'' +
                ", email='" + email + '\'' +
                ", disciplinas="  +
                '}';
    }
}