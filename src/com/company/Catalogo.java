package com.company;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    public static int totalFilmes = 0;
    public static List<Filme> filmes = new ArrayList<>(); // Inicialize a lista diretamente aqui

    public Catalogo(int totalFilme) {
        this.totalFilmes = totalFilme;
        this.filmes=new ArrayList<>();
        // Não é mais necessário inicializar filmes aqui, pois já fizemos isso acima.
    }

    public static void adicionarFilme(Filme filme) {
        filmes.add(filme);
        totalFilmes++;
    }

    public static boolean removerFilmePorTitulo(String titulo) {
        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(titulo)) {
                filmes.remove(filme);
                totalFilmes--;
                return true;
            }
        }
        return false;
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

    public static List<Filme> getFilmes() {
        return filmes; // Retorna a lista de filmes
    }

    public int getTotalFilmes() {
        return totalFilmes; // Retorna o total de filmes
    }
}
