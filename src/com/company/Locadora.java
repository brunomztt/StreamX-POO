package com.company;

import java.util.ArrayList;
import java.util.List;

public class Locadora {
    private static List<Usuario> usuariosCadastrados = new ArrayList<>();




    // cadastrar um novo usuário
    public static void cadastrar(String nome, String sobrenome, String email, String senha) {
        //chama o metodo que confere o email, o metodo retorna true, entao aqui tem que ser falso
        if (!verificarUsuarioCadastrado(email)) {
            Usuario usuario = new Usuario(nome, sobrenome, email, senha);
            //adiciona na lista
            usuariosCadastrados.add(usuario);
            System.out.println("Cadastro realizado com sucesso!");
        }
        else {
            System.out.println("Usuário já cadastrado com este email.");
        }
    }

    // Método para verificar se o usuário já está cadastrado pelo email
    private static boolean verificarUsuarioCadastrado(String email) {
        //percorre a lista
        for (Usuario usuario : usuariosCadastrados) {
            if (usuario.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    // Método para autenticar o usuário pelo email e senha
    public static Usuario login(String email, String senha) {
        for (Usuario usuario : usuariosCadastrados) {
            //verifica se tem um usuario com os dados digitados
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                //retorna esse usuario
                return usuario;
            }
        }
        //caso nao encontre
        return null;
    }


}