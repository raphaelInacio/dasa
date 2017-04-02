package com.dasa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.dasa.domain.Campanha;
import com.dasa.domain.ParticipacaoCampanhaAnoResponse;
import com.dasa.domain.ProporcaoParticipacaoCampanhaAnoResponse;
import com.dasa.repository.CampanhasRepository;

@Service
public class CampanhasServiceImpl implements CampanhasService {

	@Autowired
	private CampanhasRepository campanhasRepository;

	@Override
	public Campanha inserirCampanha(Campanha campanha) {
		if (StringUtils.isEmpty(campanha.getAno())) {
			throw new IllegalArgumentException("Parametro Ano é Obrigatório");
		}

		if (StringUtils.isEmpty(campanha.getSexo())) {
			throw new IllegalArgumentException("Parametro Sexo é Obrigatório");
		}

		if (StringUtils.isEmpty(campanha.getCampanha())) {
			throw new IllegalArgumentException("Parametro Campanha é Obrigatório");
		}

		return campanhasRepository.save(campanha);
	}

	@Override
	public Iterable<Campanha> buscarInformacoesCampanhas(Optional<String> ano) {

		final String anoPesquisa = ano.get();

		if (!ano.isPresent()) {
			throw new IllegalArgumentException("Parametro Ano é Obrigatório");
		}

		return campanhasRepository.findByAno(anoPesquisa);
	}

	@Override
	public ParticipacaoCampanhaAnoResponse obterDadosCampanhaPorAno(Optional<String> ano) {

		final String anoPesquisa = ano.get();
		Iterable<Campanha> dadosDePesquisa;

		if (!ano.isPresent()) {
			throw new IllegalArgumentException("Parametro Ano é Obrigatório");
		}

		dadosDePesquisa = campanhasRepository.findByAno(anoPesquisa);

		return new ParticipacaoCampanhaAnoResponse(dadosDePesquisa, anoPesquisa);
	}

	@Override
	public ProporcaoParticipacaoCampanhaAnoResponse obterProporcaoDadosCampanhaPorAno(Optional<String> ano) {

		final String anoPesquisa = ano.get();
		Iterable<Campanha> dadosDePesquisa;

		if (!ano.isPresent()) {
			throw new IllegalArgumentException("Parametro Ano é Obrigatório");
		}

		dadosDePesquisa = campanhasRepository.findByAno(anoPesquisa);

		return new ProporcaoParticipacaoCampanhaAnoResponse(dadosDePesquisa, anoPesquisa);
	}

}
