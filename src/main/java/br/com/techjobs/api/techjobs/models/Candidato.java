package br.com.techjobs.api.techjobs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotEmpty(message = "Candidato precisa de um E-mail")
    private String Email;
    @NotEmpty(message = "Candidato precisa de uma Senha")
    private String Senha;
    @NotEmpty(message = "Candidato precisa de um Nome")
    private String Nome;

    public Candidato() {

    }

    public Candidato(Long id, String email, String senha, String nome) {
        super();
        this.Id = id;
        this.Email = email;
        this.Senha = senha;
        this.Nome = nome;
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
}
