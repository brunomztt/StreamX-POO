package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        Locadora.carregarUsuarios(); //carrega dados persistidos
        // recommit
        // frame
        JFrame frame = new JFrame("Stream X");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // DARK
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(45, 52, 54));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Bem VIDNO
        JLabel welcomeLabel = new JLabel("Bem-vindo ao Stream X!!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.WHITE);

        // BOTOES
        JButton cadastroButton = new JButton("Cadastro");
        cadastroButton.setFont(new Font("Arial", Font.BOLD, 18));
        cadastroButton.setBackground(new Color(87, 101, 116));
        cadastroButton.setForeground(Color.WHITE);
        cadastroButton.setFocusPainted(false);
        cadastroButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));
        loginButton.setBackground(new Color(87, 101, 116));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ADD
        panel.add(welcomeLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(cadastroButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(loginButton);

        frame.add(panel, BorderLayout.CENTER);

        cadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarCadastroFrame();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarLoginFrame();
            }
        });

        frame.setVisible(true);
    }

    private static void criarCadastroFrame() {
        JFrame cadastroFrame = new JFrame("Cadastro");
        cadastroFrame.setSize(400, 300);
        JPanel cadastroPanel = new JPanel();
        cadastroPanel.setLayout(new GridLayout(5, 2));
        cadastroPanel.setBackground(new Color(45, 52, 54));
        cadastroPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

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

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                String sobrenome = sobrenomeField.getText();
                String email = emailField.getText();
                String senha = new String(senhaField.getPassword());
                Locadora.cadastrar(nome, sobrenome, email, senha);
                Locadora.salvarUsuarios();
                JOptionPane.showMessageDialog(cadastroFrame, "Cadastro realizado com sucesso!");
                cadastroFrame.dispose();
            }
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
        submitButton.setForeground(Color.WHITE);

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

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = emailField.getText();
                String password = new String(senhaField.getPassword());

                // Verifica o login do admin
                Administrador admin = new Administrador("Admin", "");
                if (admin.login(username, password)) { // método admin.login retorna true se corresponder
                    JOptionPane.showMessageDialog(loginFrame, admin.getSaudacao());
                    loginFrame.dispose();
                } else {
                    // Verificação do login de usuário normal
                    Usuario usuarioLogado = Locadora.login(username, password);
                    if (usuarioLogado != null) {
                        JOptionPane.showMessageDialog(loginFrame, usuarioLogado.getSaudacao());
                        loginFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(loginFrame, "Usuário ou senha incorretos. Tente novamente.");
                    }
            }
        }            
        })
            ;}
}
