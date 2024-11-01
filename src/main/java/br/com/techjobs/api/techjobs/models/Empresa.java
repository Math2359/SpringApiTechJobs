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
    private Long Id;
    @NotEmpty(message = "Empresa precisa de um E-mail")
    private String Email;
    @NotEmpty(message = "Empresa precisa de uma Senha")
    private String Senha;
    @NotEmpty(message = "Empresa precisa de um Nome")
    private String Nome;
    @Size(min = 14, max = 14, message = "CNPJ inválido")
    @NotEmpty(message = "Empresa precisa de um CNPJ")
    private String Cnpj;

    public Empresa() {

    }

    public Empresa(Long id, String email, String senha, String nome, String cnpj) {
        super();
        this.Id = id;
        this.Email = email;
        this.Senha = senha;
        this.Nome = nome;
        this.Cnpj = cnpj;
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getSenha() {
        return this.Senha;
    }

    public void setSenha(String senha) {
        this.Senha = senha;
    }

    public String getNome() {
        return this.Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getCnpj() {
        return this.Cnpj;
    }

    public void setCnpj(String cnpj) {
        this.Cnpj = cnpj;
    }
}
