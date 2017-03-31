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

	private String campanha;

	private String sexo;

	private String ano;

	public Campanha(String campanha, String sexo, String ano) {
		super();
		this.campanha = campanha;
		this.sexo = sexo;
		this.ano = ano;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCampanha() {
		return campanha;
	}

	public void setCampanha(String campanha) {
		this.campanha = campanha;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

}
