package com.dasa.domain;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class EstatisticaAnoResponse {

	private String ano;
	private BigDecimal populacaoTotal;
	private Long percentualHomens;
	private Long percentualMulheres;

	public EstatisticaAnoResponse(DadoPopulacional pop) {
		this.ano = pop.getAno();
		this.populacaoTotal = pop.getPopulacaoTotal();
		this.percentualHomens = calcularPercentualSobre(pop.getPopulacaoTotal(), pop.getTotalHomens());
		this.percentualMulheres = calcularPercentualSobre(pop.getPopulacaoTotal(), pop.getTotalMulheres());
	}

	private Long calcularPercentualSobre(BigDecimal valorTotal, Long valorObtido) {
		Long porcentagem = ((valorObtido * 100) / valorTotal.longValue());
		System.out.println(porcentagem);
		return porcentagem;
	}

	public String getAno() {
		return ano;
	}

	public BigDecimal getPopulacaoTotal() {
		return populacaoTotal;
	}

	public Long getPercentualHomens() {
		return percentualHomens;
	}

	public Long getPercentualMulheres() {
		return percentualMulheres;
	}
}
