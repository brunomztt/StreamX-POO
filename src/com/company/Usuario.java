package com.company;

public class Usuario extends Pessoa {
    protected String email;
    protected String senha;

    public Usuario(String nome, String sobrenome, String email, String senha, boolean statusAtivo) {
        super(nome, sobrenome, statusAtivo);
        this.email = email;
        this.senha = senha;
    }

    @Override
    public String getSaudacao() {
        return "Olá, " + nome + " " + sobrenome + "!";
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void cancelarConta() {
        this.statusAtivo = false;
        System.out.println("Conta cancelada com sucesso.");
    }

    public boolean isAtivo() {
        return statusAtivo;
    }
}
