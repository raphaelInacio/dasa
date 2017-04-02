package com.dasa.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ProporcaoParticipacaoCampanhaAnoResponseTest {

	@Test
	public void deveCriarOsDadosDeParticipacaoDeCampanhaPorAno() {

		List<Campanha> campanhas = new ArrayList<Campanha>();
		String ano = "2017";
		campanhas.addAll(criarDadosCampanha(TipoCampanha.MAMA, Sexo.M, ano, Long.valueOf(5)));
		campanhas.addAll(criarDadosCampanha(TipoCampanha.MAMA, Sexo.F, ano, Long.valueOf(35)));

		campanhas.addAll(criarDadosCampanha(TipoCampanha.PROSTATA, Sexo.F, ano, Long.valueOf(1)));
		campanhas.addAll(criarDadosCampanha(TipoCampanha.PROSTATA, Sexo.M, ano, Long.valueOf(3)));

		ProporcaoParticipacaoCampanhaAnoResponse response = new ProporcaoParticipacaoCampanhaAnoResponse(campanhas,
				ano);

		assertEquals(ano, response.getAno());
		assertEquals(TipoCampanha.MAMA, response.getProporcaoCampanha().get(0).getCampanha());
		assertEquals(Long.valueOf(5), response.getProporcaoCampanha().get(0).getTotallHomens());
		assertEquals(Long.valueOf(35), response.getProporcaoCampanha().get(0).getTotalMulheres());
	}

	private List<Campanha> criarDadosCampanha(TipoCampanha tipoCampanha, Sexo sexo, String ano, Long qtd) {
		List<Campanha> dadosCampanha = new ArrayList<Campanha>();
		for (int i = 0; i < qtd; i++) {
			dadosCampanha.add(new Campanha(tipoCampanha, sexo, ano));
		}
		return dadosCampanha;
	}

}
