package com.dasa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dasa.domain.Campanha;
import com.dasa.domain.ParticipacaoCampanhaAnoResponse;
import com.dasa.domain.ProporcaoParticipacaoCampanhaAnoResponse;
import com.dasa.domain.Sexo;
import com.dasa.domain.TipoCampanha;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CampanhasServiceImplTest {

	@Autowired
	private CampanhasServiceImpl serviceMock;

	@Test
	public void deveInserirCampanha() {
		Campanha campanha = new Campanha(TipoCampanha.MAMA, Sexo.M, "2017");
		Campanha campanhaInserida = serviceMock.inserirCampanha(campanha);
		assertNotNull(campanhaInserida);
		assertEquals(campanha.getAno(), campanhaInserida.getAno());
		assertEquals(campanha.getCampanha(), campanhaInserida.getCampanha());
		assertEquals(campanha.getSexo(), campanhaInserida.getSexo());
	}

	@Test
	public void deveBuscarInformacoesCampanhas() {
		Iterable<Campanha> response = serviceMock.buscarInformacoesCampanhas(Optional.of("2010"));
		assertNotNull(response);
	}

	@Test
	public void deveObterDadosCampanhaPorAno() {
		ParticipacaoCampanhaAnoResponse response = serviceMock.obterDadosCampanhaPorAno(Optional.of("2010"));
		assertNotNull(response);
	}

	@Test
	public void deveObterProporcaoDadosCampanhaPorAno() {
		ProporcaoParticipacaoCampanhaAnoResponse response = serviceMock .obterProporcaoDadosCampanhaPorAno(Optional.of("2010"));
		assertNotNull(response);
	}

}
