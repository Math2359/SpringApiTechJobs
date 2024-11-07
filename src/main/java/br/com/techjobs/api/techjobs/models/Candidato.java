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
    private Long id;
    @NotEmpty(message = "Candidato precisa de um E-mail")
    private String email;
    @NotEmpty(message = "Candidato precisa de uma Senha")
    private String senha;
    @NotEmpty(message = "Candidato precisa de um Nome")
    private String nome;

    public Candidato() {

    }

    public Candidato(Long id, String email, String senha, String nome) {
        super();
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
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
}
