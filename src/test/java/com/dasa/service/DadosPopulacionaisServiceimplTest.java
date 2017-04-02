package com.dasa.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dasa.domain.CrescimentoPopulacional;
import com.dasa.domain.DadoPopulacional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DadosPopulacionaisServiceimplTest {

	@Autowired
	DadosPopulacionaisServiceimpl serviceMock;

	@Test
	public void deveObterPopulacaoPorAno() {
		DadoPopulacional response = serviceMock.obterPopulacaoPorAno(Optional.of("2010"));
		assertNotNull(response);
	}

	@Test
	public void deveObterTaxaDeCrescimentoPopulacional() {
		CrescimentoPopulacional response = serviceMock.obterTaxaDeCrescimentoPopulacional(Optional.of("2010"), Optional.of("2016"));
		assertNotNull(response);
	}

}
