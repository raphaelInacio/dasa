package com.dasa.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ParticipacaoCampanhaAnoResponse {

	private String ano;
	private List<ParticipacaoCampanha> campanhas;

	public ParticipacaoCampanhaAnoResponse(Iterable<Campanha> dadosCampanha, String ano) {
		this.ano = ano;
		this.campanhas = new ArrayList<ParticipacaoCampanha>();
		for (TipoCampanha tipoCampanha : TipoCampanha.values()) {
			campanhas.add(calcular(tipoCampanha, dadosCampanha));
		}
	}

	private ParticipacaoCampanha calcular(TipoCampanha tipoCampanha, Iterable<Campanha> dadosCampanha) {
		long totalParticipantes = 0;

		for (Campanha campanha : dadosCampanha) {
			if (tipoCampanha.equals(campanha.getCampanha())) {
				totalParticipantes++;
			}
		}

		return new ParticipacaoCampanha(tipoCampanha, totalParticipantes);
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public List<ParticipacaoCampanha> getCampanhas() {
		return campanhas;
	}

	public void setCampanhas(List<ParticipacaoCampanha> campanhas) {
		this.campanhas = campanhas;
	}
}
