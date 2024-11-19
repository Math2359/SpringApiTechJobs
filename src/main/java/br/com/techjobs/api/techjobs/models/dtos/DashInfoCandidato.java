package br.com.techjobs.api.techjobs.models.dtos;

public class DashInfoCandidato {
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

    private Long vagasAplicadas;

    public Long getVagasAplicadas() {
        return vagasAplicadas;
    }

    public void setVagasAplicadas(Long vagasAplicadas) {
        this.vagasAplicadas = vagasAplicadas;
    }

    public DashInfoCandidato(String nome, String email, Long disponivel, Long aplicadas) {
        this.nome = nome;
        this.email = email;
        this.vagasAplicadas = aplicadas;
        this.vagasDisponiveis = disponivel;
    }
}
