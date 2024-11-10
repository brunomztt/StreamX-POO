package com.company;
public class Administrador extends Pessoa {

  private static final String username = "admin";
  private static final String password = "123";

  public Administrador(String nome, String sobrenome) {
    super(nome, sobrenome);
  }

  public boolean login(String user, String pass) {
    return username.equals(user) && password.equals(pass);
  }
  @Override
  public String getSaudacao() {
    return "seja bem-vindo ao perfil do adm " + username;
  }
}
