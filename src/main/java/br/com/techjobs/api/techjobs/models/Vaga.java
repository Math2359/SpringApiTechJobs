package br.com.techjobs.api.techjobs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@ManyToOne
	@JoinColumn(name = "id_empresa")
    private Empresa empresa;
    private String cargo;
    private String modelo;
    private String nivel;
    private String cep;
    private String numero;
    private String descricao;
    private Double salario;

    public Vaga() {

    }

    public Vaga(Empresa empresa, String cargo, String modelo, String nivel, String cep, String numero, String descricao, Double salario) {
        super();
        this.empresa = empresa;
        this.cargo = cargo;
        this.modelo = modelo;
        this.nivel = nivel;
        this.cep = cep;
        this.numero = numero;
        this.descricao = descricao;
        this.salario = salario;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNivel() {
        return this.nivel;
    }

    public void setNivel(String nivelExperiencia) {
        this.nivel = nivelExperiencia;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getSalario() {
        return this.salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
