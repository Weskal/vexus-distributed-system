package com.cadastrouser.CadastroUsuarios;

import jakarta.persistence.*;

// Transforma uma classe em uma entidade do BD
@Entity
@Table(name="tb_cadastro_usuarios")
public class UserModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String pass;
    private String cidade;
    private String estado;
    private int idade;

    public UserModel() {
    }

    public UserModel(String nome, String email, String pass, int idade, String cidade, String estado) {
        this.nome = nome;
        this.email = email;
        this.pass = pass;
        this.idade = idade;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
