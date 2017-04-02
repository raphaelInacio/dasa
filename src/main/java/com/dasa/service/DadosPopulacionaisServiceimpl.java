package com.dasa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dasa.domain.CrescimentoPopulacional;
import com.dasa.domain.DadoPopulacional;
import com.dasa.repository.DadosPopulacionaisRepository;

@Service
public class DadosPopulacionaisServiceimpl implements DadosPopulacionaisService {

	@Autowired
	private DadosPopulacionaisRepository dadosPopulacionaisRepository;

	@Override
	public DadoPopulacional obterPopulacaoPorAno(final Optional<String> ano) {

		final String anoCenso = ano.get();

		if (!ano.isPresent()) {
			throw new IllegalArgumentException("Parametro Ano é Obrigatório");
		}

		return dadosPopulacionaisRepository.findByAno(anoCenso);
	}

	@Override
	public CrescimentoPopulacional obterTaxaDeCrescimentoPopulacional(final Optional<String> paramAnoBase,
			final Optional<String> paramAnoPesquisa) {

		CrescimentoPopulacional crescimentoPopulacional = null;
		final String anoPesquisa = paramAnoPesquisa.get();
		final String anoBase = paramAnoBase.get();

		if (!paramAnoBase.isPresent() || !paramAnoPesquisa.isPresent()) {
			throw new IllegalArgumentException("Parametro Obrigatórios não informados");
		}

		DadoPopulacional dadosPopulacionalAnoPesquisa = dadosPopulacionaisRepository.findByAno(anoPesquisa);
		DadoPopulacional dadosPopulacionalAnoBase = dadosPopulacionaisRepository.findByAno(anoBase);

		if (dadosPopulacionalAnoBase != null && dadosPopulacionalAnoPesquisa != null) {

			final Double periodo = (Double.valueOf(anoPesquisa) - Double.valueOf(anoBase));
			final Double populacaoFinal = dadosPopulacionalAnoPesquisa.getPopulacaoTotal().doubleValue();
			final Double populacaoInicial = dadosPopulacionalAnoBase.getPopulacaoTotal().doubleValue();

			crescimentoPopulacional = new CrescimentoPopulacional(periodo, populacaoInicial, populacaoFinal);
		}

		return crescimentoPopulacional;
	}
}
