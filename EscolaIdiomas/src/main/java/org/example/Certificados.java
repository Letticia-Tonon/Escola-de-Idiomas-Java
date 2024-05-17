package org.example;

import java.time.LocalDate;

public class Certificados {
    private int id;
    private int aluno_id;
    private int cursos_id;
    private LocalDate data_conclusao;

    public Certificados(int id, int aluno_id, int cursos_id, LocalDate data_conclusao) {
        this.id = id;
        this.aluno_id = aluno_id;
        this.cursos_id = cursos_id;
        this.data_conclusao = data_conclusao;
    }

    public Certificados() {};

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

    public int getCursos_id() {
        return cursos_id;
    }

    public void setCursos_id(int cursos_id) {
        this.cursos_id = cursos_id;
    }

    public LocalDate getData_conclusao() {
        return data_conclusao;
    }

    public void setData_conclusao(LocalDate data_conclusao) {
        this.data_conclusao = data_conclusao;
    }
}
