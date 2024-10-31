package com.company;

public class Usuario extends Pessoa {
    protected String email;
    protected String senha;
    protected boolean statusAtivo;


    public Usuario(String nome, String sobrenome, String email, String senha){
        super(nome, sobrenome);
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha(){return senha;}


    public void cancelarConta() {
        this.statusAtivo = false;
        System.out.println("Conta cancelada com sucesso.");
    }

    public boolean isAtivo() {
        return statusAtivo;
    }
}