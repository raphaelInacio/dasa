package com.dasa.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DadosParticipacaoCampanhaAnoResponseTest {

	@Test
	public void deveRetornarDadosParticipacaoCampanhaPorAno() {
		
		List<Campanha> dadosCampanha = new ArrayList<Campanha>();
		String ano = "2017";
		Long participantesPesquisaProstata = new Long(120);
		Long participantesPesquisaMama = new Long(0);

		dadosCampanha.addAll(criarDadosCampanha(TipoCampanha.PROSTATA, Sexo.M, ano, participantesPesquisaProstata));

		ParticipacaoCampanhaAnoResponse response = new ParticipacaoCampanhaAnoResponse(dadosCampanha, ano);

		assertEquals(ano, response.getAno());
		assertEquals(participantesPesquisaMama, response.getCampanhas().get(0).getParticipantes());
		assertEquals(TipoCampanha.MAMA, response.getCampanhas().get(0).getCampanha());

		assertEquals(participantesPesquisaProstata, response.getCampanhas().get(1).getParticipantes());
		assertEquals(TipoCampanha.PROSTATA, response.getCampanhas().get(1).getCampanha());
	}

	private List<Campanha> criarDadosCampanha(TipoCampanha tipoCampanha, Sexo sexo, String ano, Long qtd) {
		List<Campanha> dadosCampanha = new ArrayList<Campanha>();
		for (int i = 0; i < qtd; i++) {
			dadosCampanha.add(new Campanha(tipoCampanha, sexo, ano));
		}
		return dadosCampanha;
	}

}
