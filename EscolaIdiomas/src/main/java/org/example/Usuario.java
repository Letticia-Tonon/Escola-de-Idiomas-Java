package org.example;

public abstract class Usuario{
    private int id;
    private String nome;
    private String email;
    private String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha = senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void mostrar() {
        System.out.println("########## Usuario ##########");
        System.out.println("id:     " + id);
        System.out.println("Nome:     " + nome);
        System.out.println("email: " + email);
        System.out.println("Senha:    " + senha);
    }


}