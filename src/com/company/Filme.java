package com.company;

import java.util.ArrayList;
import java.util.List;

public class Filme {
    protected String titulo;
    protected int ano;
    protected String genero;
    protected String diretor;
    protected double duracao;
    protected String descricao;
    protected String classificacao;
    protected double avaliacaoMedia;
    private List<Double> avaliacoes;
    protected double preco;


    public Filme (String titulo, int ano, String genero, String diretor, double duracao, String descricao, String classificacao, double avaliacaoMedia, double preco){
        this.titulo = titulo;
        this.ano = ano;
        this.genero = genero;
        this.diretor = diretor;
        this.duracao = duracao;
        this.descricao = descricao;
        this.classificacao = classificacao;
        this.avaliacaoMedia = avaliacaoMedia;
        this.avaliacoes = new ArrayList<>();
        this.preco = preco;
    }

    public Filme(String titulo, int ano, String genero, String diretor, double duracao, String descricao, String classificacao, double avaliacaoMedia, String classificacao1, double avaliacaoMedia1, double preco) {
    }

    public String getDescricaoFilme() {
        return "Título: " + titulo + ", Ano: " + ano + ", Diretor: " + diretor;
    }

    public void atualizarDescricao(String novaDescricao) {
        this.descricao = novaDescricao;
    }

    public void atualizarAvaliacao(double novaAvaliacao) {
        if (novaAvaliacao >= 0 && novaAvaliacao <= 10) {
            avaliacoes.add(novaAvaliacao);

            // calcula a média das avaliações
            double soma = 0;
            for (double avaliacao : avaliacoes) {
                soma += avaliacao;
            }
            this.avaliacaoMedia = soma / avaliacoes.size(); // atualiza a média da avaliação

            // exibe a média da avaliação ao usuário
            System.out.println("Avaliação do filme: " + titulo + "\n" + this.avaliacaoMedia);
        } else {
            System.out.println("Avaliação deve estar entre 0 e 10.");
        }
    }

    public String getGenero(){return genero;}

    public double getPreco(){ return preco;}
}