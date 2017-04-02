package com.dasa.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

import lombok.Data;

@Data
public class CrescimentoPopulacional {

	private BigDecimal taxaDeCrescimento;

	public CrescimentoPopulacional(Double periodo, Double populacaoInicial, Double populacaoFinal) {
		super();
		this.calcular(periodo, populacaoInicial, populacaoFinal);
	}

	public void calcular(Double periodo, Double populacaoInicial, Double populacaoFinal) {
		this.taxaDeCrescimento = new BigDecimal(
				(Math.pow((populacaoFinal / populacaoInicial), (1 / periodo)) - 1) * 100).setScale(2,
						RoundingMode.HALF_DOWN);
	}

	public BigDecimal getTaxaDeCrescimento() {
		return taxaDeCrescimento;
	}

	public void setTaxaDeCrescimento(BigDecimal taxaDeCrescimento) {
		this.taxaDeCrescimento = taxaDeCrescimento;
	}

}
