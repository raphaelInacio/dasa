package com.dasa.service;

import java.util.Optional;

import com.dasa.domain.Campanha;
import com.dasa.domain.DadosParticipacaoCampanhaAnoResponse;

public interface CampanhasService {

	Campanha inserirCampanha(Campanha campanha);

	Iterable<Campanha> buscarInformacoesCampanhas(final Optional<String> ano);

	DadosParticipacaoCampanhaAnoResponse obterDadosCampanhaPorAno(Optional<String> ano);

}
