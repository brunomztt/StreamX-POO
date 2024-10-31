package com.company;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Aluguel {
    protected Filme filme;
    protected LocalDate dataAluguel;
    protected LocalDate dataExpiracao;
    protected LocalDate dataDevolucao;
    protected boolean devolvido;
    protected int diasAlugados;
    protected double valorTotal;


    public Aluguel(Filme filme, int diasAlugados) {
        this.filme = filme;
        this.dataAluguel = LocalDate.now();
        this.dataExpiracao = dataAluguel.plusDays(diasAlugados);
        this.diasAlugados = diasAlugados;
        this.valorTotal = filme.getPreco() * diasAlugados;
        this.devolvido = false;
    }


    public double calcularMulta(int diasAtraso) {
        double taxaMulta = 5.0; // taxa de multa diária
        return diasAtraso * taxaMulta;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public String exibirResumoAluguel() {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        String dataAluguelStr = formatoData.format(dataAluguel);
        String dataDevolucaoStr = (dataDevolucao != null) ? formatoData.format(dataDevolucao) : "Ainda não devolvido";

        return "Dados do Aluguel:\n" +
                //"Filme: " + filme.getTitulo() + "\n" +
                "Data do Aluguel: " + dataAluguelStr + "\n" +
                "Data de Devolução: " + dataDevolucaoStr + "\n" +
                "Valor do Aluguel: R$" + valorTotal + "\n" +
                "Status de Devolução: " + (devolvido ? "Devolvido" : "Pendente");

    }
}