package br.com.ienh.springacessobanco.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "semestre")
    private String semestre;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "aluno_turma",
                joinColumns = @JoinColumn(name="turma_id"),
                inverseJoinColumns = @JoinColumn(name="aluno_id"))
    private List<Aluno> alunos;

    public Turma(String semestre) {
        this.semestre = semestre;
    }

    public Turma() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", semestre='" + semestre + '\'' +
                '}';
    }

}
