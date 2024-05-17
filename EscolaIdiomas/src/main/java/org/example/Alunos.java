package org.example;

import java.util.logging.Logger;

public class Alunos extends Usuario {
    private Logger logger = Logger.getLogger(Alunos.class.getName());
@Override
    public void mostrar() {
        System.out.println("########## Aluno ##########");
        System.out.println("id:     " + getId());
        System.out.println("Nome:     " + getNome());
        System.out.println("email: " + getEmail());
        System.out.println("Senha:    " + getSenha());
    }


}