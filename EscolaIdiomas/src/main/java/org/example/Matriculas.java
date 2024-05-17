package org.example;

import java.time.LocalDate;

public class Matriculas {
    private int id;
    private int aluno_id;
    private Cursos curso_id;
    private LocalDate data_matricula;

    public Matriculas(int id, int aluno_id, Cursos cursos_id, LocalDate data_matricula) {
        this.id = id;
        this.aluno_id = aluno_id;
        this.curso_id = cursos_id;
        this.data_matricula = data_matricula;
    }

    public Matriculas() {
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAluno_id() {
        return aluno_id;
    }

    public void setAluno_id(int aluno_id) {
        this.aluno_id = aluno_id;
    }

    public Cursos getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int cursos_id) {
        this.curso_id = curso_id;
    }

    public LocalDate getData_matricula() {
        return data_matricula;
    }

    public void setData_matricula(LocalDate data_matricula) {
        this.data_matricula = data_matricula;
    }
}
