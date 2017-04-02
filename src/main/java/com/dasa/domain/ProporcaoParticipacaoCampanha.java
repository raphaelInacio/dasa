package com.dasa.domain;

import lombok.Data;

@Data
public class ProporcaoParticipacaoCampanha {

	private TipoCampanha campanha;
	private Long totallHomens;
	private Long totalMulheres;

	public ProporcaoParticipacaoCampanha(TipoCampanha campanha, Iterable<Campanha> dadosPesquisa) {
		this.campanha = campanha;
		this.totallHomens = calcularTotalSobre(Sexo.M, campanha, dadosPesquisa);
		this.totalMulheres = calcularTotalSobre(Sexo.F, campanha, dadosPesquisa);
	}

	private Long calcularTotalSobre(Sexo sexo, TipoCampanha tipoCampanha, Iterable<Campanha> dadosPesquisa) {
		Long totalParticipantes = new Long(0);

		for (Campanha campanha : dadosPesquisa) {
			if (sexo.equals(campanha.getSexo()) && tipoCampanha.equals(campanha.getCampanha())) {
				totalParticipantes++;
			}
		}
		return totalParticipantes;
	}

	public TipoCampanha getCampanha() {
		return campanha;
	}

	public void setCampanha(TipoCampanha campanha) {
		this.campanha = campanha;
	}

	public Long getTotallHomens() {
		return totallHomens;
	}

	public void setTotallHomens(Long totallHomens) {
		this.totallHomens = totallHomens;
	}

	public Long getTotalMulheres() {
		return totalMulheres;
	}

	public void setTotalMulheres(Long totalMulheres) {
		this.totalMulheres = totalMulheres;
	}

}
