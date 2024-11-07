package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Locadora {
    private static List<Usuario> usuariosCadastrados = new ArrayList<>();
    private static final String ARQUIVO_USUARIOS = "usuarios.txt";

    static {
        carregarUsuariosDoArquivo();
    }

    public static void cadastrar(String nome, String sobrenome, String email, String senha) {
        if (!verificarUsuarioCadastrado(email)) {
            Usuario usuario = new Usuario(nome, sobrenome, email, senha);
            usuariosCadastrados.add(usuario);
            salvarUsuarioNoArquivo(usuario);
            System.out.println("Cadastro realizado com sucesso!");
        } else {
            System.out.println("Usuário já cadastrado com este email.");
        }
    }

    private static boolean verificarUsuarioCadastrado(String email) {
        for (Usuario usuario : usuariosCadastrados) {
            if (usuario.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static Usuario login(String email, String senha) {
        for (Usuario usuario : usuariosCadastrados) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }

    private static void salvarUsuarioNoArquivo(Usuario usuario) {
        if (!emailExisteNoArquivo(usuario.getEmail())) {
            try (FileWriter writer = new FileWriter(ARQUIVO_USUARIOS, true)) {
                String linha = usuario.getNome() + "," + usuario.getSobrenome() + "," + usuario.getEmail() + "," + usuario.getSenha();
                writer.write(linha + "\n");
            } catch (IOException e) {
                System.out.println("Erro ao salvar o usuário no arquivo.");
            }
        }
    }

    private static boolean emailExisteNoArquivo(String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_USUARIOS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length > 2 && dados[2].equals(email)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
        }
        return false;
    }

    private static void carregarUsuariosDoArquivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_USUARIOS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 4) {
                    String nome = dados[0];
                    String sobrenome = dados[1];
                    String email = dados[2];
                    String senha = dados[3];
                    Usuario usuario = new Usuario(nome, sobrenome, email, senha);
                    usuariosCadastrados.add(usuario);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os usuários: " + e.getMessage());
        }
    }
}
