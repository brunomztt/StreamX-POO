package com.company;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class TesteTxt {
    private static final String ARQUIVO="usuarios.txt";


    public int escrever(List<Usuario>usuarios){
        int resultado = 0;
        try(FileWriter fw=new FileWriter(ARQUIVO)){
            for (Usuario usuario : usuarios){
                String linha = usuario.getNome() + ";" + usuario.getSobrenome() + ";" + usuario.getEmail() + ";" + usuario.getSenha();
                fw.write(linha+"\n");
            }
            resultado = 1;
            System.out.println("dados salvos com sucesso");
        }catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
        return resultado;
    }
    //metodo que lê os usuarios do arquivo e retorna a lista

    public List<Usuario> leitura(){
        List<Usuario> usuarios = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(ARQUIVO))){
            String linha;
            while ((linha=bf.readLine()) != null){
                //divide a linha nos dados separados com ";
                String[] dados = linha.split(";");
                if(dados.length == 4){
                    String nome = dados[0];
                    String sobrenome = dados[1];
                    String email = dados[2];
                    String senha = dados[3];
                    Usuario usuario= new Usuario(nome,sobrenome,email,senha);
                    usuarios.add(usuario);
                }
            }
        }

        catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
        return usuarios;
    }
}
