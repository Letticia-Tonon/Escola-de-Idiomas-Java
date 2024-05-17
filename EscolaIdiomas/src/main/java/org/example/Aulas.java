package org.example;

import java.time.LocalDate;

public class Aulas{
    private int Id;
    private LocalDate data_hora;
    private String conteudo;
    private int curso_id;
    private int professor_id;

    public Aulas(int id, LocalDate data_hora, String conteudo, int curso_id, int professor_id) {
        Id = id;
        this.data_hora = data_hora;
        this.conteudo = conteudo;
        this.curso_id = curso_id;
        this.professor_id = professor_id;
    }

    public Aulas(){};

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public LocalDate getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDate data_hora) {
        this.data_hora = data_hora;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    public int getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
    }
}
