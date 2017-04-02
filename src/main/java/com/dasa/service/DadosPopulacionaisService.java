package com.dasa.service;

import java.util.Optional;

import com.dasa.domain.CrescimentoPopulacional;
import com.dasa.domain.DadoPopulacional;

public interface DadosPopulacionaisService {
	DadoPopulacional obterPopulacaoPorAno(final Optional<String> ano);

	CrescimentoPopulacional obterTaxaDeCrescimentoPopulacional(final Optional<String> paramAnoBase,
			final Optional<String> paramAnoPesquisa);
}
