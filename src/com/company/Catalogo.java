package com.company;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private int totalFilmes;
    private ArrayList<Filme> filmes;

    public Catalogo(int totalFilme) {
        this.totalFilmes = totalFilme;
    }

    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
        totalFilmes++;
    }

    public void removerFilme(Filme filme) {
        filmes.remove(filme);
        totalFilmes--;
    }

    public List<Filme> buscarFilmesPorGenero(String genero) {
        List<Filme> filmesGenero = new ArrayList<>();
        for (Filme filme : filmes) {
            if (filme.getGenero().equals(genero)) {
                filmesGenero.add(filme);
            }
        }
        return filmesGenero;
    }
}
