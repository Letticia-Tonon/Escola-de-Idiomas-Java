package org.example;

public class Notas {
    private int id;
    private int aluno_id;
    private int curso_id;
    private float nota;

    public Notas(int id, int aluno_id, int cursos_id, float nota) {
        this.id = id;
        this.aluno_id = aluno_id;
        this.curso_id = cursos_id;
        this.nota = nota;
    }

    public Notas() {
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

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
}
