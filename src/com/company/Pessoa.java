package com.company;

public abstract class Pessoa {
    protected String nome;
    protected String sobrenome;
    protected boolean statusAtivo;

    public Pessoa(String nome, String sobrenome, boolean statusAtivo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.statusAtivo = statusAtivo;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public abstract String getSaudacao();

    public boolean isAtivo() {
        return statusAtivo;
    }
}
