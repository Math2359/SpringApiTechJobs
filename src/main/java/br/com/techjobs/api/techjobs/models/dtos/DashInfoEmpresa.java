package br.com.techjobs.api.techjobs.models.dtos;

import java.util.List;

import br.com.techjobs.api.techjobs.models.Vaga;

public class DashInfoEmpresa {
    private String nome;
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String email;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private Long vagasDisponiveis;
    public Long getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setVagasDisponiveis(Long vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

    private List<Vaga> vagas;

    public List<Vaga> getVagasAplicadas() {
        return vagas;
    }

    public void setVagasAplicadas(List<Vaga> vagas) {
        this.vagas = vagas;
    }

    public DashInfoEmpresa(String nome, String email, Long disponivel, List<Vaga> vagas) {
        this.nome = nome;
        this.email = email;
        this.vagas = vagas;
        this.vagasDisponiveis = disponivel;
    }
}
