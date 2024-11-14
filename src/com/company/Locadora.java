package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Locadora {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static final String ARQUIVO_USUARIOS = "usuarios.txt";

    public static void cadastrar(String nome, String sobrenome, String email, String senha) {
        Usuario usuario = new Usuario(nome, sobrenome, email, senha);
        usuarios.add(usuario);
        salvarUsuarios();
    }

    public static Usuario login(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }

    // Método para obter o catálogo de filmes
    public static List<Filme> getCatalogoFilmes() {
        return Catalogo.getFilmes(); // Retorna a lista de filmes
    }

    // Salva a lista de usuários em um arquivo
    public static void salvarUsuarios() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_USUARIOS))) {
            for (Usuario usuario : usuarios) {
                writer.write(usuario.getNome() + ";" + usuario.getSobrenome() + ";" + usuario.getEmail() + ";" + usuario.getSenha());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void carregarUsuarios() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_USUARIOS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 4) {
                    Usuario usuario = new Usuario(
                            dados[0],
                            dados[1],
                            dados[2],
                            dados[3]
                    );
                    usuarios.add(usuario);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de usuários não encontrado. Será criado automaticamente.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar os usuários: " + e.getMessage());
        }
    }
}
