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
    private Long Id;
	@ManyToOne
	@JoinColumn(name = "id_empresa")
    private Empresa Empresa;
    private String Cargo;
    private String Modelo;
    private String Nivel;
    private String Cep;
    private String Numero;
    private String Descricao;
    private Double Salario;

    public Vaga() {

    }

    public Vaga(Empresa empresa, String cargo, String modelo, String nivel, String cep, String numero, String descricao, Double salario) {
        super();
        this.Empresa = empresa;
        this.Cargo = cargo;
        this.Modelo = modelo;
        this.Nivel = nivel;
        this.Cep = cep;
        this.Numero = numero;
        this.Descricao = descricao;
        this.Salario = salario;
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public Empresa getEmpresa() {
		return this.Empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.Empresa = empresa;
	}

    public String getCargo() {
        return this.Cargo;
    }

    public void setCargo(String cargo) {
        this.Cargo = cargo;
    }

    public String getModelo() {
        return this.Modelo;
    }

    public void setModelo(String modelo) {
        this.Modelo = modelo;
    }

    public String getNivel() {
        return this.Nivel;
    }

    public void setNivel(String nivelExperiencia) {
        this.Nivel = nivelExperiencia;
    }

    public String getCep() {
        return this.Cep;
    }

    public void setCep(String cep) {
        this.Cep = cep;
    }

    public String getNumero() {
        return this.Numero;
    }

    public void setNumero(String numero) {
        this.Numero = numero;
    }

    public String getDescricao() {
        return this.Descricao;
    }

    public void setDescricao(String descricao) {
        this.Descricao = descricao;
    }

    public Double getSalario() {
        return this.Salario;
    }

    public void setSalario(Double salario) {
        this.Salario = salario;
    }
}
