package com.dasa.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ProporcaoParticipacaoCampanhaAnoResponse {

	private String ano;
	private List<ProporcaoParticipacaoCampanha> proporcaoCampanha;

	public ProporcaoParticipacaoCampanhaAnoResponse(Iterable<Campanha> dadosPesquisa, String ano) {
		this.ano = ano;
		this.proporcaoCampanha = new ArrayList<ProporcaoParticipacaoCampanha>();
		for (TipoCampanha campanha : TipoCampanha.values()) {
			proporcaoCampanha.add(new ProporcaoParticipacaoCampanha(campanha, dadosPesquisa));
		}
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public List<ProporcaoParticipacaoCampanha> getProporcaoCampanha() {
		return proporcaoCampanha;
	}

	public void setProporcaoCampanha(List<ProporcaoParticipacaoCampanha> proporcaoCampanha) {
		this.proporcaoCampanha = proporcaoCampanha;
	}

}
