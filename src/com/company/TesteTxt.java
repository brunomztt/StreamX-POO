package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TesteTxt {
    public int escreve(String nome){
        int resultado = 0;
        try{
            FileWriter fw = new FileWriter(nome);
            fw.write("Primeira linha \n");
            fw.write("Segunda linha \n");
            fw.close();
            resultado = 1;
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
        return resultado;
    }

    public int leitura(String nome){
        int linhas = 0;
        try{
            FileReader fr = new FileReader(nome);
            BufferedReader bf = new BufferedReader(fr);
            String linha = bf.readLine();
            while(linha != null){
                linha = bf.readLine();
                linhas++;
            }
            bf.close(); // Feche o BufferedReader após o uso
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
        return linhas;
    }
}