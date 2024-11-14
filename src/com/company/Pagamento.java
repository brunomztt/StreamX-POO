package com.company;

import java.time.LocalDate;

public class Pagamento {
    protected double valor;
    protected LocalDate dataPagamento;
    protected String metodoPagamento;
    protected boolean confirmado;

    public Pagamento(double valor, LocalDate dataPagamento, String metodoPagamento){
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.metodoPagamento = metodoPagamento;
        this.confirmado = false;
    }


    public void pagarCredito(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado com sucesso no crédito.");
    }

    public void pagarDebito(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado com sucesso no débito.");
    }

    public void pagamentoConfirmado(){
        this.confirmado = true;
        System.out.println("Pagamento confitmado.");
    }

    public void gerarRecibo() throws PagamentoNaoConfirmadoException {
        if (confirmado)
        {
            System.out.println("Recibo no valor de R$" + valor + "\nData do Pagamento: " + dataPagamento+"\nMétodo de pagamento: " + metodoPagamento);
        }
        else {
            throw new PagamentoNaoConfirmadoException ("Pagamento não confirmado. Não é possível gerar recibo.");
        }
    }

    public void processarRecibo(){
        try {
            gerarRecibo();
        } catch (PagamentoNaoConfirmadoException e) {
            System.out.println(e.getMessage());
        }
    }

}