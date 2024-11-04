package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;

        Usuario usuario = null;


        while(option != 2) {
            System.out.println("Bem-vindo ao Stream X!!");
            System.out.println("1. Cadastro.");
            System.out.println("2. Login.");
            System.out.println("Para começar, escolha uma das duas opções:");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Para realizar seu cadastro, informe os seguintes dados:");
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Sobrenome: ");
                    String sobrenome = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Senha: ");
                    String senha = sc.nextLine();

                    Locadora.cadastrar(nome, sobrenome, email, senha);
                    break;

                case 2:
                    boolean loginSuccessful = false;

                    while (!loginSuccessful) { // Loop para tentar login até que seja bem-sucedido
                        System.out.println("Informe os dados para login:");
                        System.out.print("Email: ");
                        String loginEmail = sc.nextLine();
                        System.out.print("Senha: ");
                        String loginSenha = sc.nextLine();

                        //usuarioLogado vai armazenar o retorno do metodo login(o usuario da lista ou null)
                        Usuario usuarioLogado = Locadora.login(loginEmail, loginSenha);
                        if (usuarioLogado != null) {
                            System.out.println("Login realizado com sucesso!");
                            System.out.println(usuarioLogado.getSaudacao());
                            loginSuccessful = true;
                        }
                        else {
                            System.out.println("Email ou senha incorretos. Tente novamente.");
                        }
                    }
                    break;


                default:
                    System.out.println("Opção Inválida!");
            }
        }

        sc.close();
    }
}
