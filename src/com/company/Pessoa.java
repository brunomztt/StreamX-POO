package com.company;

public abstract class Pessoa {
    protected String nome;
    protected String sobrenome;


    public Pessoa(String nome, String sobrenome){
        this.nome = nome;
        this.sobrenome = sobrenome;
    }
}