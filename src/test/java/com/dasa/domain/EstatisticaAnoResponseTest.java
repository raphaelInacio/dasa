package com.dasa.domain;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class EstatisticaAnoResponseTest {

	@Test
	public void deveRetornarPercentualEntreHomenseMulheres() {
		DadoPopulacional pop = new DadoPopulacional("2010", "100", "30", "70");
		EstatisticaAnoResponse estatistica = new EstatisticaAnoResponse(pop);
		assertEquals(new BigDecimal(100), estatistica.getPopulacaoTotal());
		assertEquals("2010", estatistica.getAno());
		assertEquals(new Long(30), estatistica.getPercentualHomens());
		assertEquals(new Long(70), estatistica.getPercentualMulheres());
	}

}
