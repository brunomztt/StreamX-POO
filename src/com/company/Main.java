package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        Locadora.carregarUsuarios(); // Carrega dados persistidos

        JFrame frame = new JFrame("Stream X");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(45, 52, 54));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel welcomeLabel = new JLabel("Bem-vindo ao Stream X!!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.WHITE);

        JButton cadastroButton = new JButton("Cadastro");
        cadastroButton.setFont(new Font("Arial", Font.BOLD, 18));
        cadastroButton.setBackground(new Color(87, 101, 116));
        cadastroButton.setForeground(Color.WHITE);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));
        loginButton.setBackground(new Color(87, 101, 116));
        loginButton.setForeground(Color.WHITE);

        panel.add(welcomeLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(cadastroButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(loginButton);

        frame.add(panel, BorderLayout.CENTER);

        cadastroButton.addActionListener(e -> criarCadastroFrame());
        loginButton.addActionListener(e -> criarLoginFrame());

        frame.setVisible(true);
    }

    private static void criarCadastroFrame() {
        JFrame cadastroFrame = new JFrame("Cadastro");
        cadastroFrame.setSize(400, 300);
        JPanel cadastroPanel = new JPanel(new GridLayout(5, 2));
        cadastroPanel.setBackground(new Color(45, 52, 54));

        JTextField nomeField = new JTextField();
        JTextField sobrenomeField = new JTextField();
        JTextField emailField = new JTextField();
        JPasswordField senhaField = new JPasswordField();
        JButton submitButton = new JButton("Cadastrar");
        submitButton.setBackground(new Color(87, 101, 116));
        submitButton.setForeground(Color.WHITE);

        JLabel nomeLabel = new JLabel("Nome:", SwingConstants.RIGHT);
        nomeLabel.setForeground(Color.WHITE);
        JLabel sobrenomeLabel = new JLabel("Sobrenome:", SwingConstants.RIGHT);
        sobrenomeLabel.setForeground(Color.WHITE);
        JLabel emailLabel = new JLabel("Email:", SwingConstants.RIGHT);
        emailLabel.setForeground(Color.WHITE);
        JLabel senhaLabel = new JLabel("Senha:", SwingConstants.RIGHT);
        senhaLabel.setForeground(Color.WHITE);

        cadastroPanel.add(nomeLabel);
        cadastroPanel.add(nomeField);
        cadastroPanel.add(sobrenomeLabel);
        cadastroPanel.add(sobrenomeField);
        cadastroPanel.add(emailLabel);
        cadastroPanel.add(emailField);
        cadastroPanel.add(senhaLabel);
        cadastroPanel.add(senhaField);
        cadastroPanel.add(new JLabel(""));
        cadastroPanel.add(submitButton);

        cadastroFrame.add(cadastroPanel);
        cadastroFrame.setVisible(true);

        submitButton.addActionListener(e -> {
            String nome = nomeField.getText();
            String sobrenome = sobrenomeField.getText();
            String email = emailField.getText();
            String senha = new String(senhaField.getPassword());
            Locadora.cadastrar(nome, sobrenome, email, senha);
            Locadora.salvarUsuarios();
            JOptionPane.showMessageDialog(cadastroFrame, "Cadastro realizado com sucesso!");
            cadastroFrame.dispose();
        });
    }

    private static void criarLoginFrame() {
        JFrame loginFrame = new JFrame("Login");
        loginFrame.setSize(400, 200);
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));
        loginPanel.setBackground(new Color(45, 52, 54));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField emailField = new JTextField();
        JPasswordField senhaField = new JPasswordField();
        JButton submitButton = new JButton("Login");
        submitButton.setBackground(new Color(87, 101, 116));
        submitButton.setForeground(Color.BLACK);

        JLabel emailLabel = new JLabel("Email:", SwingConstants.RIGHT);
        emailLabel.setForeground(Color.WHITE);
        JLabel senhaLabel = new JLabel("Senha:", SwingConstants.RIGHT);
        senhaLabel.setForeground(Color.WHITE);

        loginPanel.add(emailLabel);
        loginPanel.add(emailField);
        loginPanel.add(senhaLabel);
        loginPanel.add(senhaField);
        loginPanel.add(new JLabel(""));
        loginPanel.add(submitButton);

        loginFrame.add(loginPanel);
        loginFrame.setVisible(true);

        submitButton.addActionListener(e -> {
            String username = emailField.getText();
            String password = new String(senhaField.getPassword());

            // Verifica o login do admin
            Administrador admin = new Administrador("Admin", "");
            if (admin.login(username, password)) {
                JOptionPane.showMessageDialog(loginFrame, admin.getSaudacao());
                loginFrame.dispose();
                criarmenufilmesFrame();
            } else {
                Usuario usuarioLogado = Locadora.login(username, password);
                if (usuarioLogado != null) {
                    JOptionPane.showMessageDialog(loginFrame, usuarioLogado.getSaudacao());
                    loginFrame.dispose();
                    criarCatalogoFrame(); // Exibe o catálogo de filmes para usuário comum
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Usuário ou senha incorretos. Tente novamente.");
                }
            }
        });
    }


    private static void criarmenufilmesFrame() {
        JFrame adminFrame = new JFrame("Selecione a opção desejada:");
        adminFrame.setSize(400, 300);
        JPanel adminPanel = new JPanel(new GridLayout(2, 1));
        adminPanel.setBackground(new Color(45, 52, 54));

        JButton addButton = new JButton("Adicionar Filme");
        JButton deleteButton = new JButton("Excluir Filme");

        addButton.setBackground(new Color(87, 101, 116));
        deleteButton.setBackground(new Color(87, 101, 116));

        adminPanel.add(addButton);
        adminPanel.add(deleteButton);

        adminFrame.add(adminPanel);
        adminFrame.setVisible(true);

        addButton.addActionListener(e -> criarAdicionarFilmeFrame());
    }

    private static void criarAdicionarFilmeFrame(){
        JFrame addFilmeFrame = new JFrame("Adicionar Filme");
        addFilmeFrame.setSize(400, 400);
        addFilmeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel addFilmePanel = new JPanel();
        addFilmePanel.setLayout(new GridLayout(7, 2, 10, 10));
        addFilmePanel.setBackground(new Color(45, 52, 54));
        addFilmePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Labels para cada campo
        JLabel tituloLabel = new JLabel("Título:");
        tituloLabel.setForeground(Color.WHITE);
        JLabel anoLabel = new JLabel("Ano:");
        anoLabel.setForeground(Color.WHITE);
        JLabel generoLabel = new JLabel("Gênero:");
        generoLabel.setForeground(Color.WHITE);
        JLabel diretorLabel = new JLabel("Diretor:");
        diretorLabel.setForeground(Color.WHITE);
        JLabel duracaoLabel = new JLabel("Duração:");
        duracaoLabel.setForeground(Color.WHITE);
        JLabel descricaoLabel = new JLabel("Descrição:");
        descricaoLabel.setForeground(Color.WHITE);
        JLabel precoLabel = new JLabel("Preço:");
        precoLabel.setForeground(Color.WHITE);

        JTextField tituloField = new JTextField();
        JTextField anoField = new JTextField();
        JTextField generoField = new JTextField();
        JTextField diretorField = new JTextField();
        JTextField duracaoField = new JTextField();
        JTextField descricaoField = new JTextField();
        JTextField precoField = new JTextField();

        // Adiciona as labels e campos ao painel
        addFilmePanel.add(tituloLabel);
        addFilmePanel.add(tituloField);
        addFilmePanel.add(anoLabel);
        addFilmePanel.add(anoField);
        addFilmePanel.add(generoLabel);
        addFilmePanel.add(generoField);
        addFilmePanel.add(diretorLabel);
        addFilmePanel.add(diretorField);
        addFilmePanel.add(duracaoLabel);
        addFilmePanel.add(duracaoField);
        addFilmePanel.add(descricaoLabel);
        addFilmePanel.add(descricaoField);
        addFilmePanel.add(precoLabel);
        addFilmePanel.add(precoField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(45, 52, 54));
        JButton submitButton = new JButton("Adicionar Filme");
        submitButton.setBackground(new Color(87, 101, 116));
        submitButton.setForeground(Color.BLACK);
        buttonPanel.add(submitButton);

        addFilmeFrame.setLayout(new BorderLayout());
        addFilmeFrame.add(addFilmePanel, BorderLayout.CENTER);
        addFilmeFrame.add(buttonPanel, BorderLayout.SOUTH);
        addFilmeFrame.setVisible(true);

        // Evento para adicionar filme
        submitButton.addActionListener(e -> {
            try {
                String titulo = tituloField.getText();
                int ano = Integer.parseInt(anoField.getText());
                String genero = generoField.getText();
                String diretor = diretorField.getText();
                double duracao = Double.parseDouble(duracaoField.getText());
                String descricao = descricaoField.getText();
                double preco = Double.parseDouble(precoField.getText());

                Filme novoFilme = new Filme(titulo, ano, genero, diretor, duracao, descricao, "Não classificado", 0.0, preco);
                Catalogo.adicionarFilme(novoFilme);

                JOptionPane.showMessageDialog(addFilmeFrame, "Filme adicionado com sucesso!");
                addFilmeFrame.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(addFilmeFrame, "Erro ao adicionar filme. Verifique os campos.");
            }
        });
    }


    private static void criarCatalogoFrame() {
        JFrame catalogoFrame = new JFrame("Catálogo de Filmes");
        catalogoFrame.setSize(500, 400);

        JTextArea catalogoTextArea = new JTextArea();
        catalogoTextArea.setEditable(false);

        for (Filme filme : Catalogo.getFilmes()) {
            catalogoTextArea.append(filme.getDescricaoFilme() + "\n\n");
        }

        JScrollPane scrollPane = new JScrollPane(catalogoTextArea);
        catalogoFrame.add(scrollPane);
        catalogoFrame.setVisible(true);
    }


}


