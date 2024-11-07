package br.com.techjobs.api.techjobs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Empresa precisa de um E-mail")
    private String email;
    @NotEmpty(message = "Empresa precisa de uma Senha")
    private String senha;
    @NotEmpty(message = "Empresa precisa de um Nome")
    private String nome;
    @Size(min = 14, max = 14, message = "CNPJ inválido")
    @NotEmpty(message = "Empresa precisa de um CNPJ")
    private String cnpj;

    public Empresa() {

    }

    public Empresa(Long id, String email, String senha, String nome, String cnpj) {
        super();
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
