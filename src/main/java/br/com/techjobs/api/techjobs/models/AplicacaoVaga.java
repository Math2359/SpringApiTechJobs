package br.com.techjobs.api.techjobs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AplicacaoVaga {
    public AplicacaoVaga() {

    }

    public AplicacaoVaga(Vaga vaga, Candidato candidato, String situacao) {
        super();
        this.candidato = candidato;
        this.vaga = vaga;
        this.situacao = situacao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
	@JoinColumn(name = "id_vaga")
    private Vaga vaga;
    @ManyToOne
	@JoinColumn(name = "id_candidato")
    private Candidato candidato;
    private String situacao;
    
    public String getSituacao() {
        return situacao;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
	public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Candidato getCandidato() {
        return candidato;
    }
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
	public Vaga getVaga() {
        return vaga;
    }
    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }
}
