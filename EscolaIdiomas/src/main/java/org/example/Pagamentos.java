package org.example;

import java.time.LocalDate;

public class Pagamentos {
    private int id;
    private int aluno_id;
    private int curso_id;
    private float valor;
    private LocalDate data_pagamento;

    public Pagamentos(int id, Alunos aluno_id, int cursos_id, float valor, LocalDate data_pagamento) {
        this.id = id;
        this.aluno_id = aluno_id.getId();
        this.curso_id = cursos_id;
        this.valor = valor;
        this.data_pagamento = data_pagamento;
    }

    public Pagamentos() {
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public LocalDate getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(LocalDate data_pagamento) {
        this.data_pagamento = data_pagamento;
    }
}
