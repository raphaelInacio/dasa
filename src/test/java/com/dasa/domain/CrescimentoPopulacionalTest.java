package com.dasa.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CrescimentoPopulacionalTest {

	@Test
	public void deveRetornarTaxaDeCrescimentoPopulacional() {
		// =(POTÊNCIA(2.375.151/2.238.526;1/10)-1)*100
		// Resultado: 0,59419237, ou seja 0,59%
		CrescimentoPopulacional ano2017 = new CrescimentoPopulacional(new Double(10), new Double(2.238526),
				new Double(2.375151));
		Double taxaEsperada = new Double(0.59);
		assertEquals(taxaEsperada.toString(), ano2017.getTaxaDeCrescimento().toString());
	}

}
