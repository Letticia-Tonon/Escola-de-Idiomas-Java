package org.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Professores extends Usuario{
    private int id;
    private String nome;
    private String email;
    private String senha;

    private Logger logger = Logger.getLogger(Professores.class.getName());
    public Professores(){};
    public Professores(int Id, String Nome,
                  String Email, String Senha){
        try {
            setId(Id);
            setNome(Nome);
            setEmail(Email);
            setSenha(Senha);
        }
        catch(Exception err){
            setId(Integer.parseInt(""));
            setNome("");
            setEmail("");
            setSenha("");
            logger.log(Level.WARNING, "Ocorreu uma exceção – Valores padrões definidos");
        }

    }

    @Override
    public void mostrar() {
        System.out.println("########## Professor ##########");
    System.out.println("id:     " + getId());
    System.out.println("Nome:     " + getNome());
    System.out.println("email: " + getEmail());
    System.out.println("Senha:    " + getSenha());
    }


}