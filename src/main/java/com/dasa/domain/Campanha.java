package com.dasa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "campanhas")
public class Campanha {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Sexo sexo;

	private String ano;
	
	private TipoCampanha campanha;

	public Campanha() {
	}

	public Campanha(TipoCampanha campanha, Sexo sexo, String ano) {
		super();
		this.setCampanha(campanha);
		this.setSexo(sexo);
		this.ano = ano;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public TipoCampanha getCampanha() {
		return campanha;
	}

	public void setCampanha(TipoCampanha campanha) {
		this.campanha = campanha;
	}

}
